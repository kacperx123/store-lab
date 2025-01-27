package pl.wsei.store.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.wsei.store.model.Basket;

import java.util.List;

public class BasketService {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public void buyItem(String item, int quantity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Sprawdzamy, czy produkt już istnieje w koszyku
            Basket basket = em.createQuery("SELECT b FROM Basket b WHERE b.item = :item", Basket.class)
                    .setParameter("item", item)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);  // Jeśli nie ma produktu, to null

            if (basket == null) {
                // Jeśli produktu nie ma w koszyku, tworzymy nowy obiekt Basket
                basket = new Basket();
                basket.setItem(item);
                basket.setQuantity(quantity);  // Ustawiamy ilość na podaną
                em.persist(basket);  // Zapisujemy nowy produkt w koszyku
            } else {
                // Jeśli produkt już istnieje w koszyku, aktualizujemy jego ilość
                basket.setQuantity(basket.getQuantity() + quantity);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    public void sellItem(String item, int quantity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Basket basket = em.createQuery("SELECT b FROM Basket b WHERE b.item = :item", Basket.class)
                    .setParameter("item", item)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);  // Jeśli nie ma produktu, to null

            if (basket == null) {
                throw new IllegalArgumentException("Produkt nie istnieje w koszyku");
            } else {

                if (basket.getQuantity() < quantity) {
                    throw new IllegalArgumentException("Nie ma wystarczającej ilości produktów w koszyku");
                } else {

                    basket.setQuantity(basket.getQuantity() - quantity);

                    if (basket.getQuantity() == 0) {
                        em.remove(basket);
                    }
                }
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }


    public List<Basket> getAllItems() {
        EntityManager em = emf.createEntityManager();
        List<Basket> items;
        try {
            items = em.createQuery("SELECT b FROM Basket b", Basket.class).getResultList();
        } finally {
            em.close();
        }
        return items;
    }

    public void clearBasket() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Basket").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
