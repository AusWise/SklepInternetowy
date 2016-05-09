package name.auswise.spring.webstore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductDAOImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ProductDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Product> list() {
		String sql = "SELECT * FROM produkt";
		
		List<Product> listProduct = jdbcTemplate.query(sql, new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				
				product.setId(rs.getInt("ID"));
				product.setName(rs.getString("Nazwa"));
				product.setPrice(rs.getDouble("Cena"));
				
				return product;
			}});
		
		return listProduct;
	}

}
