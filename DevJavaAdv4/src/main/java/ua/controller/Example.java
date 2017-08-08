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
		
//		����� �� ������ ���� �� ������� ����
//		System.out.println("������ ����� ����:");
//		String name = sc.next();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.name=:name", Cafe.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
		
//		����� �� ������ ���� � ������� ��������
//		System.out.println("������ ����� ���� ��������:");
//		BigDecimal bottonValue = sc.nextBigDecimal();
//		System.out.println("������ ������ ���� ��������:");
//		BigDecimal topValue = sc.nextBigDecimal();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.rate "
//				+ "BETWEEN :first AND :second",Cafe.class)
//				.setParameter("first",bottonValue )
//				.setParameter("second",topValue )
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
		
//		����� �� ������ ���� �� ����������� �� ������� �����
//		System.out.println("������ �����:");
//		String value = sc.next();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c "
//				+ "WHERE c.name LIKE :name", Cafe.class)
//				.setParameter("name", value)
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
//		����� �� ������ ����, �� ����� ������� ��� � � ���� ������� ����� ��������� :
//		System.out.println("������ ������� ����:");
//		BigDecimal rate = sc.nextBigDecimal();
//		System.out.println("������ ��� ���� ����:");
//		String name = sc.next();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.name = :name "
//				+ "AND c.rate > :rate", Cafe.class)
//				.setParameter("rate", rate)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
//		����� �� ������ ���� � �������� ����
//		System.out.println("������ ��� ����");
//		String name = sc.next();
//		List<Cuisine> cuisines = em.createQuery("SELECT c FROM Cuisine c WHERE c.name = :name", Cuisine.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cuisine cuisine : cuisines) {
//			System.out.println(cuisine);
//		}
//		����� �� ������ ����, ��� ���������� � ������� �����
//		System.out.println("������ �����");
//		String name = sc.next();
//		List<Cuisine> cuisines = em.createQuery("SELECT c FROM Cafe c WHERE c.name LIKE :name", Cuisine.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cuisine cuisine : cuisines) {
//			System.out.println(cuisine);
//		}
//		����� �� ������ ����� � �������� ����
//		System.out.println("������ ��� ������:");
//		String name = sc.next();
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.title = :name", Meal.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Meal meal : meals) {
//			System.out.println(meal);
//		}
//		����� �� ������ c����, �� ����������� � ������� �����
//		System.out.println("������ �����:");
//		String name = sc.next();
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.title LIKE :name", Meal.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Meal meal : meals) {
//			System.out.println(meal);
//		}
//		����� �� ������ �����, ���� ���� ����������� � �����
//		System.out.println("������ ����� ���� ����");
//		BigDecimal bottonValue = sc.nextBigDecimal();
//		System.out.println("������ ������ ���� ����");
//		BigDecimal topValue = sc.nextBigDecimal();
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.price BETWEEN :first AND :second", Meal.class)
//				.setParameter("first", bottonValue)
//				.setParameter("second", topValue)
//				.getResultList();
//		for (Meal meal : meals) {
//			System.out.println(meal);
//		}
//		����� �� ������ �����, �� ����������� �� ������� ����� � ���� ���� ����� �� �������
//		System.out.println("������ �����:");
//		String name = sc.next();
//		System.out.println("������ ���y");
//		BigDecimal price = sc.nextBigDecimal();
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.title = :name AND m.price <:price", Meal.class)
//				.setParameter("name", name)
//				.setParameter("price", price)
//				.getResultList();
//		for (Meal meal : meals) {
//			System.out.println(meal);
//		}
//		����� �� ������ �������, �� ����� ������� ������� ���� �� � �������
		System.out.println("������ ������� ����");
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
