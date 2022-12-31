package com.trainings.lambdas;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.trainings.lambdas.FPTraining.Gender;
import com.trainings.lambdas.FPTraining.Person;

class FPTrainingTest {

	@Test
	void testNotEmptyListOfPeople() {
		Assert.assertTrue(FPTraining.getPeople().size()>0);
	}
	
	@Test
	void testGetAllMaleInPeople() {
		Assert.assertTrue(FPTraining.getMalePeople().stream().allMatch(people -> people.getGender().equals(FPTraining.Gender.MALE)));
	}
	
	@Test
	void testGetGenderMapWithMaleAndFemalePeople() {
		Map<Gender, List<Person>> genderMap = FPTraining.getGenderMap();
		Assert.assertTrue(genderMap.size()>0);
		
		Assert.assertEquals(FPTraining.Gender.values().length, genderMap.keySet().size());
		
		Assert.assertEquals(2, genderMap.get(Gender.FEMALE).size());
	}
	
	@Test
	void testGetYougestPersonInTheList() {
		Assert.assertEquals("Ramon Dos Anjos", FPTraining.getYoungestPerson().getName());
	}
	
	@Test
	void testGetOldestMalePerson() {
		Assert.assertEquals("Antonio Carlos", FPTraining.getOldestMalePerson().getName());
	}
	
	@Test
	void testEverybodyEqualOrOver18() {
		Assert.assertFalse(FPTraining.isEverybodyEqualOrOver18());
	}
	
	@Test
	void testGetPeopleUnder18() {
		FPTraining training = new FPTraining();
		Assert.assertEquals(List.of(training.new Person("Ramon Dos Anjos", 13, Gender.MALE)).toString(), FPTraining.getPeopleUnder18().toString());
	}
	
	@Test
	void testGetFinalPrice() {
		Assert.assertEquals("R$2226.45", FPTraining.getFinalPrice(new ProductB("Notebook", 2560.53, 0.15)));
	}

}
