package bebra.rzhork_ua.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("Prototype Bean created: " + this);
    }

    public void doSomething() {
        System.out.println("Doing something with Prototype Bean: " + this);
    }
}
