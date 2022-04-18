//package com.kalburgi.customermanager.customerDetails;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@RunWith(MockitoJUnitRunner.class)
//class CustomerControllerTest {
//
//    @InjectMocks
//    CustomerController customerController;
//
//    @Mock
//    CustomerService customerService ;
//
//
//    @Test
//    public void getAllCustomerTest() {
//        Mockito.when(customerService.findAllCustomers()).thenReturn(getCustomerList());
//        ResponseEntity<List<Customer>> responseEntity =  customerController.getAllCustomer();
//        assertEquals(getCustomerList().get(0), responseEntity.getBody().get(0));
//    }
//
//    @Test
//    void getCustomerByIdTest() {
//    }
//
//    @Test
//    void addCustomerTest() {
//        when(customerService.addCustomer(Mockito.any())).thenReturn(getCustomer());
//        ResponseEntity<Customer> responseEntity =  customerController.addCustomer(new Customer());
//        assertEquals("8197916519", Objects.requireNonNull(responseEntity.getBody()).getPhone());
//    }
//
//    @Test
//    void updateCustomerTest() {
//    }
//
//    @Test
//    void deleteCustomerTest() {
//    }
//
//    public List<Customer> getCustomerList(){
//        List<Customer> customerList = new ArrayList<>();
//        customerList.add(new Customer(1L , "prathamesh kalburgi" , "8197916519", new java.util.Date(System.currentTimeMillis()),"gokak" ,
//                false,  "RCNQFd8QPhsHKI4I8ctZ81sPx8kc1HfQgDGSL7LbVrDyxzHw7yfdZ1S5PlUoGODk", "prathameshkalburgi@gmail.com",
//                "https://media-exp1.licdn.com/dms/image/C4D03AQHQww9hnhwiJw/profile-displayphoto-shrink_800_800/0/1597904434214?e=1655337600&v=beta&t=6rNrf-x0dJtgeztqdJC9s9xb36zaCteadThbcqHNwU8",
//                "9cacc645-9691-4e83-870f-d51a10c5fdd4"));
//        return customerList;
//    }
//
//    public Customer getCustomer(){
//        return new Customer(1L , "prathamesh kalburgi" , "8197916519", new java.util.Date(System.currentTimeMillis()),"gokak" ,
//                false,  "RCNQFd8QPhsHKI4I8ctZ81sPx8kc1HfQgDGSL7LbVrDyxzHw7yfdZ1S5PlUoGODk", "prathameshkalburgi@gmail.com",
//                "https://media-exp1.licdn.com/dms/image/C4D03AQHQww9hnhwiJw/profile-displayphoto-shrink_800_800/0/1597904434214?e=1655337600&v=beta&t=6rNrf-x0dJtgeztqdJC9s9xb36zaCteadThbcqHNwU8",
//                "9cacc645-9691-4e83-870f-d51a10c5fdd4");
//    }
//}