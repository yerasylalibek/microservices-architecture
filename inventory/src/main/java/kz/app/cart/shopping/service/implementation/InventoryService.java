package kz.app.cart.shopping.service.implementation;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.app.cart.shopping.dto.InventoryDTO;
import kz.app.cart.shopping.model.InventoryItem;
import kz.app.cart.shopping.repository.InventoryItemRepository;
import kz.app.cart.shopping.service.InventoryServiceI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class InventoryService implements InventoryServiceI {

    private final InventoryItemRepository inventoryItemRepository;

    final String orderApi = "http://localhost:8086/order/";


    private Object runGetMethod(String url, Object object) {
        log.info("get method url : " + url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        try {
            HttpEntity<?> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    object.getClass());
            log.info("responseEntity in GET METHOD = {} ", responseEntity.getBody());
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception in GET method : " + e.getLocalizedMessage());
            return null;
        }
    }

    private Object runPostMethod(String url, Object body, Object object) {
        log.info("post method url : " + url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(body, headers);
        try {
            HttpEntity<?> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    object.getClass());
            log.info("responseEntity in POST METHOD = {} ", responseEntity.getBody());
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception in POST method : " + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public InventoryItem save(InventoryDTO inventoryDTO) {
        InventoryItem inventory;
        log.info("Start save method");

        if (inventoryDTO.getId() == null) {
            log.info("new inventory");
            inventory = InventoryItem.builder()
                    .productCode(inventoryDTO.getProductCode())
                    .build();
        } else {
            log.info("not new inventory");
            inventory = getById(inventoryDTO.getId());
            inventory.setProductCode(inventoryDTO.getProductCode());

        }

        InventoryItem savedInventory = inventoryItemRepository.saveAndFlush(inventory);
        log.info("savedInventory = " + savedInventory.getId());

        return savedInventory;
    }

    @Override
    public void deleteById(Long id) {
        inventoryItemRepository.deleteById(id);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "getInventoryInformationByIdFallback",
            threadPoolKey = "getById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public InventoryItem getById(Long id) {
        return null;
    }

    public InventoryItem getInventoryInformationByIdFallback(Long id){ //Название метода стоит ли менять?
        InventoryItem inventory = new InventoryItem();
        inventory.setProductCode("ProductCode is not available:Service Unavailable");
        return inventory;
    }

    @Override
    public List<InventoryItem> getAll() {
        return inventoryItemRepository.findAll();
    }
}
