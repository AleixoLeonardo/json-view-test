package com.example.demo.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.data.AreaDataMock;
import com.example.demo.model.Area;
import com.example.demo.service.AreaService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Rollback
public class AreaServiceImplTest {

	@Autowired
	private AreaService areaService;

	/*
	 * Roda toda vez antes de um teste
	 */
	@Before
	public void init() throws Exception {
		Area area = new Area();
		area.setNome(AreaDataMock.nome);
		areaService.save(area);
	}

	/*
	 * É um teste que valida quando existe o id
	 */
	@Test
	public void findByIdSuccess() throws Exception {

		Area area = areaService.findById(1);
		assertNotNull(area);
		assertEquals(AreaDataMock.nome, area.getNome());
	}

	/*
	 * É um teste que valida quando não existe o id
	 */
	@Test
	public void findByIdFailed() {
		Area area = areaService.findById(999);
		assertNull(area);
	}

	@Test
	public void saveWithoutNameFailure() {
		
		Area area1 = new Area();
//		area1.setNome("Teste");
		try {
			areaService.save(area1);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Nome precisa ser passado");
		}
	}

}
