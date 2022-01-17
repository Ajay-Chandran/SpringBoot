package learn.concept.curd;

import learn.concept.curd.model.CustomerDetailsEntity;
import learn.concept.curd.repository.CustomerDetailsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerDetailsRepositoryTest
{
	@Autowired
	CustomerDetailsRepository repository;

	@Test
	public void testRepository() 
	{
		CustomerDetailsEntity cde = new CustomerDetailsEntity();
		cde.setFirstName("Lokesh");
		cde.setLastName("Gupta");
		cde.setEmail("howtodoinjava@gmail.com");
		
		repository.save(cde);
		
		System.out.println(cde);
		
		Assert.assertNotNull(cde.getId());
	}
}
