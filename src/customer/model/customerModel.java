/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customer.model;
    import customer.db.DBConnection;
    import customer.dto.customerDto;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.List;
    import java.util.ArrayList;

/**
 *
 * @author Yashoda
 */
public class customerModel {
    
    public String saveCustomer(customerDto customerdto)throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, customerdto.getId());
        statement.setString(2, customerdto.getTitle());
        statement.setString(3, customerdto.getName());
        statement.setString(4, customerdto.getDob());
        statement.setDouble(5, customerdto.getSalary());
        statement.setString(6, customerdto.getAddress());
        statement.setString(7, customerdto.getCity());
        statement.setString(8, customerdto.getProvince());
        statement.setString(9, customerdto.getPostalCode());
        
        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Saved" : "Fail";
    
    }
    
     public String updateCustomer(customerDto customerdto) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, "
                + "CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customerdto.getTitle());
        statement.setString(2, customerdto.getName());
        statement.setString(3, customerdto.getDob());
        statement.setDouble(4, customerdto.getSalary());
        statement.setString(5, customerdto.getAddress());
        statement.setString(6, customerdto.getCity());
        statement.setString(7, customerdto.getProvince());
        statement.setString(8, customerdto.getPostalCode());
        statement.setString(9, customerdto.getId());

        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Updated" : "Fail";
    }

    public String deleteCustomer(String id) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Customer WHERE CustID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id);

        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Deleted" : "Fail";
    }
    
    public customerDto searchCustomer(String id)throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer WHERE CustId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        
         ResultSet rst = statement.executeQuery();
        if(rst.next()){
            customerDto dto = new customerDto(rst.getString(1),
                    rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getDouble(5),
                    rst.getString(6), rst.getString(7),
                    rst.getString(8), rst.getString(9));
        
            return  dto;
        }
        return null;
    }

    public List<customerDto> getAllCustomer() throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";
        PreparedStatement statement = connection.prepareStatement(sql);

        List<customerDto> customerdtos = new ArrayList<>();

        ResultSet rst = statement.executeQuery();
        while(rst.next()){
            customerDto dto = new customerDto(rst.getString(1),
                    rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getDouble(5),
                    rst.getString(6), rst.getString(7),
                    rst.getString(8), rst.getString(9));
            customerdtos.add(dto);
        }

        return customerdtos;
    }
}
