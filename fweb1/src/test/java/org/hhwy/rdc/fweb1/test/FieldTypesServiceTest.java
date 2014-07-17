package org.hhwy.rdc.fweb1.test;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.hhwy.rdc.fweb1.Utility;
import org.hhwy.rdc.fweb1.domain.FieldTypes;
import org.hhwy.rdc.fweb1.service.FieldTypesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class FieldTypesServiceTest extends BaseJUnit4TestCase {

	@Autowired
	private FieldTypesService service;

	@Test
	public void allServiceTest() {
		int objectCount = this.getRandomInt();
		int deleteCount = 0;
		int updateCount = 0;

		for (int i = 0; i < objectCount; i++) {
			FieldTypes fieldTypes = new FieldTypes();
			fieldTypes.setFieldT01(this.getRandomString());
			fieldTypes.setFieldT02(Math.rint(1000));

			service.insert(fieldTypes);

			if (this.getRandomBoolean()) {
				service.update(fieldTypes);
				updateCount++;
				continue;
			}

			if (this.getRandomBoolean()) {
				System.out.println("将被删除：" + fieldTypes.getId());
				service.delete(fieldTypes.getId());
				deleteCount++;
				continue;
			}
		}

		System.out.println("写入：" + objectCount + ", 修改：" + updateCount + ", 删除："
				+ deleteCount + "\n");

		List<FieldTypes> list = service.getAll();
		for (FieldTypes obj : list) {
			System.out.println(obj);
		}

		service.delete(list.get(0).getId());

	}

}
