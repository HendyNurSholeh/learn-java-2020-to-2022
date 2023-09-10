package programmer.zaman.now.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.database.entity.Comment;
import programmer.zaman.now.database.repository.CommentRepository;
import programmer.zaman.now.database.repository.CommentRepositoryImpl;

import java.util.List;

public class RepositoryTest {

    CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment(12,"duar", "santai AJaa");
        commentRepository.insert(comment);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
    }

    @Test
    void testFindId() {
        Comment comment = commentRepository.findById(759);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());

        Comment commentNull = commentRepository.findById(10);
        Assertions.assertNull(commentNull);
        System.out.println(commentNull);
    }

    @Test
    void testFindAll() {
        List<Comment> commentList = commentRepository.findAll();
        Assertions.assertEquals(2, commentList.size());
        System.out.println(commentList.size());
        Comment comment = commentList.get(0);
        Comment comment2 = commentList.get(1);
        System.out.println(comment.getEmail());
        System.out.println(comment2.getEmail());
    }

    @Test
    void testFindAllByEmail() {
        List<Comment> listEmail = commentRepository.findAllByEmail("hendy");
        Assertions.assertNotNull(listEmail);
        Assertions.assertEquals(1, listEmail.size());
        Assertions.assertEquals(758, listEmail.get(0).getId());

        System.out.println(listEmail.get(0).getEmail());
//        System.out.println(listEmail.get(1).getEmail());
    }
}
