package profe.springbatch.products.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import profe.springbatch.products.model.Product;

public class ProductRowMapper implements RowMapper<Product> {
	 public Product mapRow(ResultSet rs, int rowNum)
             throws SQLException {
         Product product = new Product();
         product.setId(rs.getString("id"));
         product.setNombre(rs.getString("name"));
         product.setDescripcion(rs.getString("description"));
         product.setPrecio(rs.getBigDecimal("price"));
         return product;
     }
}
