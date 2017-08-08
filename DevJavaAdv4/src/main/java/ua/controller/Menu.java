package ua.controller;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

import ua.entity.Cafe;
import ua.entity.Cuisine;
import ua.entity.Meal;
import ua.entity.OpenClose;
import ua.entity.Table;
import ua.entity.Type;

public class Menu {

	Scanner sc = new Scanner(System.in);
	
	int menu(){
		System.out.println("Якшо ви хочете додати кафе, введіть 1");
		System.out.println("Якшо ви хочете видалити кафе, введіть 2");
		System.out.println("Якшо ви хочете редагувати кафе, введіть 3");
		System.out.println("Якшо ви хочете фільтрувати по кафе, введіть 4");
		System.out.println("Якшо ви хочете фільтрувати по кухні, введіть 5");
		System.out.println("Якшо ви хочете фільтрувати по стравах, введіть 6");
		System.out.println("Якшо ви хочете фільтрувати по столиках, введіть 8");
		System.out.println("Введіть вашу цифру:");
		int menu = sc.nextInt();
		return menu;
	}
	
	void addCafe(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Cafe cafe = new Cafe();
		
		System.out.println("Ведіть назву кафе ");
		String name=sc.next();
		cafe.setName(name);
		
		System.out.println("Ведіть адрес кафе");
		String adresCafe=sc.next();
		cafe.setAddress(adresCafe);
		
		System.out.println("Ведіть тип кафе(PUB, SUSHY, BAR, CAFE, RESTAURANT) ");
		String input=sc.next();
		Type type=Type.valueOf(input.toUpperCase());
		cafe.setType(type);
		
		System.out.println("Ведіть Email кафе ");
		String email=sc.next();
		cafe.setEmail(email);
		
		System.out.println("Ведіть телефон  кафе ");
		String phone=sc.next();
		cafe.setPhone(phone);
		
		System.out.println("Ведіть повний опис кафе ");
		String fullDescr=sc.next();
		cafe.setFullDescription(fullDescr);
		
		System.out.println("Ведіть короткий опис ");
		String shordDescr=sc.next();
		cafe.setShortDescription(shordDescr);
		
		System.out.println("Ведіть з якої години працює кафе(спочатку годину потим хвилини");
		OpenClose open=new OpenClose (LocalTime.of(sc.nextInt(), sc.nextInt()));
		em.persist(open);
		
		System.out.println("Ведіть до якої години працює кафе(спочатку годину потим хвилини");
		OpenClose close=new OpenClose (LocalTime.of(sc.nextInt(), sc.nextInt()));
		cafe.setClose(close);
		em.persist(close);
		
		em.persist(cafe);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void deleteCafe() {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			System.out.println("Ведіть назву кафе яке хочите удалити");
			String name=sc.next();
		List<Cafe> list = em.createQuery("SELECT c FROM Cafe c WHERE c.name=:name", Cafe.class)
				.setParameter("name", name)
				.getResultList();
		for (Cafe cafe : list) {
			if(name.equals(cafe.getName())) {
				em.remove(cafe);
			}
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}catch(NoResultException |NonUniqueResultException e) {
		System.out.println("Ви ввели кафе якого нема в списку або яких знайдено більше одного");
	}
	}
	
	public void edit() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Ведіть назву кафе яке хочите редагувати");
		String name=sc.next();
		List<Cafe> list = em.createQuery("SELECT c FROM Cafe c WHERE c.name=:name", Cafe.class)
				.setParameter("name", name)
				.getResultList();
		for (Cafe cafe : list) {
			if(name.equals(cafe.getName())) {
				System.out.println("Ведіть назву кафе ");
				String editName=sc.next();
				cafe.setName(editName);
				
				System.out.println("Ведіть адрес кафе");
				String adresCafe=sc.next();
				cafe.setAddress(adresCafe);
				
				System.out.println("Ведіть тип кафе(PUB, SUSHY, BAR, CAFE, RESTAURANT) ");
				String input=sc.next();
				Type type=Type.valueOf(input.toUpperCase());
				cafe.setType(type);
				
				System.out.println("Ведіть Email кафе ");
				String email=sc.next();
				cafe.setEmail(email);
				
				System.out.println("Ведіть телефон  кафе ");
				String phone=sc.next();
				cafe.setPhone(phone);
				
				System.out.println("Ведіть повний опис кафе ");
				String fullDescr=sc.next();
				cafe.setFullDescription(fullDescr);
				
				
				System.out.println("Ведіть короткий опис ");
				String shordDescr=sc.next();
				cafe.setShortDescription(shordDescr);
				
				System.out.println("Ведіть з якої години працює кафе(спочатку годину потим хвилини");
				OpenClose open=new OpenClose (LocalTime.of(sc.nextInt(), sc.nextInt()));
				em.persist(open);
				
				System.out.println("Ведіть до якої години працює кафе(спочатку годину потим хвилини");
				OpenClose close=new OpenClose (LocalTime.of(sc.nextInt(), sc.nextInt()));
				cafe.setClose(close);
				
				em.persist(close);
				em.persist(cafe);
			}
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	void filtrCafe(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Якшо хочете зробити запит на вибірку кафе із заданим імям, введіть 1");
		System.out.println("Якшо хочете зробити запит на вибірку кафе в діапазоні рейтингу, введіть 2");
		System.out.println("Якшо хочете зробити запит на вибірку кафе, "
				+ "які починаються із вказаної букви, введіть 3");
		System.out.println("Якшо хочете зробити запит на вибірку кафе, "
				+ "які мають вказане імя і в яких рейтинг більше вказаного, введіть 4");
		System.out.println("Якшо хочете зробити запит на вибірку кафе з найбільшим рейтингом, введіть 5");
		System.out.println("Введіть вашу цифру:");
		int number = sc.nextInt();
		switch (number) {
		case 1:
			System.out.println("Введіть назву кафе:");
			String name = sc.next();
			List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.name=:name", Cafe.class)
					.setParameter("name", name)
					.getResultList();
			for (Cafe cafe : cafes) {
				System.out.println(cafe);
			}
			break;
		case 2:
			System.out.println("Введіть нижню межу діапазону:");
			BigDecimal bottonValue = sc.nextBigDecimal();
			System.out.println("Введіть верхню межу діапазону:");
			BigDecimal topValue = sc.nextBigDecimal();
			List<Cafe> cafes2 = em.createQuery("SELECT c FROM Cafe c WHERE c.rate "
					+ "BETWEEN :first AND :second",Cafe.class)
					.setParameter("first",bottonValue )
					.setParameter("second",topValue )
					.getResultList();
			for (Cafe cafe : cafes2) {
				System.out.println(cafe);
			}
			break;
		case 3:
			System.out.println("Введіть букву:");
			String value = sc.next();
			List<Cafe> cafes3 = em.createQuery("SELECT c FROM Cafe c "
					+ "WHERE c.name LIKE :name", Cafe.class)
					.setParameter("name", value)
					.getResultList();
			for (Cafe cafe : cafes3) {
				System.out.println(cafe);
			}
			break;
		case 4:
			System.out.println("Введіть рейтинг кафе:");
			BigDecimal rate = sc.nextBigDecimal();
			System.out.println("Введіть імя кафе кафе:");
			String name1 = sc.next();
			List<Cafe> cafes4 = em.createQuery("SELECT c FROM Cafe c WHERE c.name = :name "
					+ "AND c.rate > :rate", Cafe.class)
					.setParameter("rate", rate)
					.setParameter("name", name1)
					.getResultList();
			for (Cafe cafe : cafes4) {
				System.out.println(cafe);
			}
			break;
		case 5:
			BigDecimal rateMax = em.createQuery("SELECT max(c.rate) FROM Cafe c", BigDecimal.class).getSingleResult();
			Cafe cafe = em.createQuery("SELECT c FROM Cafe c WHERE c.rate = :rate", Cafe.class)
					.setParameter("rate", rateMax)
					.getSingleResult();
			System.out.println(cafe);
			break;

		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	void filtrCuisine(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Якшо ви хочете вибрати кухню з вказаним імям, введіть 1");
		System.out.println("Якшо ви хочете вибрати кухню, яка починається з вказаної букви, введіть 2");
		System.out.println("Введіть вашу цифру:");
		int number = sc.nextInt();
		switch (number) {
		case 1:
			System.out.println("Введіть імя кухні");
			String name = sc.next();
			List<Cuisine> cuisines = em.createQuery("SELECT c FROM Cuisine c WHERE c.name = :name", Cuisine.class)
					.setParameter("name", name)
					.getResultList();
			for (Cuisine cuisine : cuisines) {
				System.out.println(cuisine);
			}
			break;
		case 2:
			System.out.println("Введіть букву");
			String name2 = sc.next();
			List<Cuisine> cuisines2 = em.createQuery("SELECT c FROM Cafe c WHERE c.name LIKE :name", Cuisine.class)
					.setParameter("name", name2)
					.getResultList();
			for (Cuisine cuisine : cuisines2) {
				System.out.println(cuisine);
			}
			break;
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	void filtrMeal(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Якшо ви хочете вибрати страви з вказаним імям, введіть 1");
		System.out.println("Якшо ви хочете вибрати страви, які починаються з вказаної букви, введіть 2");
		System.out.println("Якшо ви хочете вибрати страви, ціна яких знаходиться в межах, введіть 3");
		System.out.println("Якшо ви хочете вибрати страви, які починаються із вказаної букви і ціна яких менша за вказану, введіть 4");
		System.out.println("Введіть вашу цифру:");
		int number = sc.nextInt();
		switch (number) {
		case 1:
			System.out.println("Введіть імя страви:");
			String name = sc.next();
			List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.title = :name", Meal.class)
					.setParameter("name", name)
					.getResultList();
			for (Meal meal : meals) {
				System.out.println(meal);
			}
			break;
		case 2:
			System.out.println("Введіть букву:");
			String name2 = sc.next();
			List<Meal> meals2 = em.createQuery("SELECT m FROM Meal m WHERE m.title LIKE :name", Meal.class)
					.setParameter("name", name2)
					.getResultList();
			for (Meal meal : meals2) {
				System.out.println(meal);
			}
			break;
		case 3:
			System.out.println("Введіть нижню межу ціни");
			BigDecimal bottonValue = sc.nextBigDecimal();
			System.out.println("Введіть верхню межу ціни");
			BigDecimal topValue = sc.nextBigDecimal();
			List<Meal> meals3 = em.createQuery("SELECT m FROM Meal m WHERE m.price BETWEEN :first AND :second", Meal.class)
					.setParameter("first", bottonValue)
					.setParameter("second", topValue)
					.getResultList();
			for (Meal meal : meals3) {
				System.out.println(meal);
			}
			break;
		case 4:
			System.out.println("Введіть букву:");
			String name4 = sc.next();
			System.out.println("Введіть цінy");
			BigDecimal price = sc.nextBigDecimal();
			List<Meal> meals4 = em.createQuery("SELECT m FROM Meal m WHERE m.title = :name AND m.price <:price", Meal.class)
					.setParameter("name", name4)
					.setParameter("price", price)
					.getResultList();
			for (Meal meal : meals4) {
				System.out.println(meal);
			break;
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	}
	void filtrTable(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
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

