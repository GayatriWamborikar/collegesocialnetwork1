package com.socialnetwork;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.socialnetwork.entity.OfficeSection;
import com.socialnetwork.entity.OfficeSectionDTO;
import com.socialnetwork.exception.OfficeSectionNotFoundException;
import com.socialnetwork.service.OfficeSectionService;

@SpringBootTest
class Collegesocialnetwork1ApplicationTests {

	@Autowired
	private OfficeSectionService officeSectionService;
	
	@Test
	void addOfficeSectionTest() {
		OfficeSection officeSection = new OfficeSection(105, "Capgi", null);
		OfficeSection testOfficeSection = this.officeSectionService.addOfficeSection(officeSection);
		assertNotNull(testOfficeSection);
		
	}
	
	@Test
	void updateOfficeSectionTest() {
		OfficeSectionDTO officeSectionDTO = new OfficeSectionDTO(105, "TestName", null);

		assertThrows(OfficeSectionNotFoundException.class, () -> this.officeSectionService.updateOfficeSection(officeSectionDTO));

	}

	@Test
	void updateOfficeSectionTest2() {
		

		OfficeSectionDTO officeSectionDTO = new OfficeSectionDTO(24, "TestName", null);

		try {
			OfficeSection updatedOfficeSection = this.officeSectionService.updateOfficeSection(officeSectionDTO);

			assertEquals("TestName", updatedOfficeSection.getDocumentType());
		} catch (OfficeSectionNotFoundException e) {
			
			e.printStackTrace();
		}

	}
}



