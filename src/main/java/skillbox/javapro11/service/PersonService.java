package skillbox.javapro11.service;

import skillbox.javapro11.api.request.RegisterRequest;
import skillbox.javapro11.model.entity.Person;

public interface PersonService {

    Person findPersonByEmail(String email);

    Person save(Person person);

    Person add(RegisterRequest registerRequest);

    String changePassword(String email, String password);

    String changeEmail(Person curPerson, String email);

    Person findById(long srcId);
}
