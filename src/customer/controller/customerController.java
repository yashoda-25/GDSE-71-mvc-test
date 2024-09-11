/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer.controller;
    import customer.dto.customerDto;
    import customer.model.customerModel;
    import java.util.List;

/**
 *
 * @author Yashoda
 */
public class customerController {
    
    private customerModel customerModel = new customerModel();

    public String saveCustomer(customerDto customerDto) throws Exception {
        String resp = customerModel.saveCustomer(customerDto);
        return resp;
    }

    public String updateCustomer(customerDto customerDto) throws Exception {
        String resp = customerModel.updateCustomer(customerDto);
        return resp;
    }

    public String deleteCustomer(String customerId) throws Exception {
        String resp = customerModel.deleteCustomer(customerId);
        return resp;
    }

    public customerDto searchCustomer(String customerId) throws Exception{
        customerDto dto = customerModel.searchCustomer(customerId);
        return dto;
    }

    public List<customerDto> getAllCustomer() throws Exception{
        List<customerDto> dtos = customerModel.getAllCustomer();
        return dtos;
    }

    
}
