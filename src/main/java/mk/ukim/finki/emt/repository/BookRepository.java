package mk.ukim.finki.emt.repository;

import mk.ukim.finki.emt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}
