package ua.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Table;

public class Example {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Scanner sc = new Scanner(System.in);
		
//		Запит на вибірку кафе із заданим імям
//		System.out.println("Введіть назву кафе:");
//		String name = sc.next();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.name=:name", Cafe.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
		
//		Запит на вибірку кафе в діапазоні рейтингу
//		System.out.println("Введіть нижню межу діапазону:");
//		BigDecimal bottonValue = sc.nextBigDecimal();
//		System.out.println("Введіть верхню межу діапазону:");
//		BigDecimal topValue = sc.nextBigDecimal();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.rate "
//				+ "BETWEEN :first AND :second",Cafe.class)
//				.setParameter("first",bottonValue )
//				.setParameter("second",topValue )
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
		
//		Запит на вибірку кафе які починаються із вказаної букви
//		System.out.println("Введіть букву:");
//		String value = sc.next();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c "
//				+ "WHERE c.name LIKE :name", Cafe.class)
//				.setParameter("name", value)
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
//		Запит на вибірку кафе, які мають вказане імя і в яких рейтинг більше вказаного :
//		System.out.println("Введіть рейтинг кафе:");
//		BigDecimal rate = sc.nextBigDecimal();
//		System.out.println("Введіть імя кафе кафе:");
//		String name = sc.next();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.name = :name "
//				+ "AND c.rate > :rate", Cafe.class)
//				.setParameter("rate", rate)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
//		Запит на вибірку кухні з вказаним імям
//		System.out.println("Введіть імя кухні");
//		String name = sc.next();
//		List<Cuisine> cuisines = em.createQuery("SELECT c FROM Cuisine c WHERE c.name = :name", Cuisine.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cuisine cuisine : cuisines) {
//			System.out.println(cuisine);
//		}
//		Запит на вибірку кухні, яка починається з вказаної букви
//		System.out.println("Введіть букву");
//		String name = sc.next();
//		List<Cuisine> cuisines = em.createQuery("SELECT c FROM Cafe c WHERE c.name LIKE :name", Cuisine.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cuisine cuisine : cuisines) {
//			System.out.println(cuisine);
//		}
//		Запит на вибірку страв з вказаним імям
//		System.out.println("Введіть імя страви:");
//		String name = sc.next();
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.title = :name", Meal.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Meal meal : meals) {
//			System.out.println(meal);
//		}
//		Запит на вибірку cтрав, які починаються з вказаної букви
//		System.out.println("Введіть букву:");
//		String name = sc.next();
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.title LIKE :name", Meal.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Meal meal : meals) {
//			System.out.println(meal);
//		}
//		Запит на вибірку страв, ціна яких знаходиться в межах
//		System.out.println("Введіть нижню межу ціни");
//		BigDecimal bottonValue = sc.nextBigDecimal();
//		System.out.println("Введіть верхню межу ціни");
//		BigDecimal topValue = sc.nextBigDecimal();
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.price BETWEEN :first AND :second", Meal.class)
//				.setParameter("first", bottonValue)
//				.setParameter("second", topValue)
//				.getResultList();
//		for (Meal meal : meals) {
//			System.out.println(meal);
//		}
//		Запит на вибірку страв, які починаються із вказаної букви і ціна яких менша за вказану
//		System.out.println("Введіть букву:");
//		String name = sc.next();
//		System.out.println("Введіть цінy");
//		BigDecimal price = sc.nextBigDecimal();
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.title = :name AND m.price <:price", Meal.class)
//				.setParameter("name", name)
//				.setParameter("price", price)
//				.getResultList();
//		for (Meal meal : meals) {
//			System.out.println(meal);
//		}
//		Запит на вибірку столиків, які мають вказану кількість місць та є вільними
		System.out.println("Введіть кількість місць");
		Integer count = sc.nextInt();
		List<Table> tables = em.createQuery("SELECT t FROM Table t WHERE t.countOfPeople = :count", Table.class)
				.setParameter("count", count)
				.getResultList();
		for (Table table : tables) {
			if (table.isFree()) {
				System.out.println(table);
			}
		}
		
		
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
