package it.jwisnowski.example.junitsuitewithspring;

import it.jwisnowski.example.junitsuitewithspring.dockers.ADockerContainer;
import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@ContextConfiguration(initializers = AbstractTestClass.ContextInitializer.class)
public class AbstractTestClass {

    @ClassRule
    public final static SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    public static class ContextInitializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext context) {
            ADockerContainer aDockerContainer = new ADockerContainer();
            aDockerContainer.start();

            context.getBeanFactory().registerResolvableDependency(
                    ADockerContainer.class, aDockerContainer);

            context.addApplicationListener(
                    (ApplicationListener<ContextClosedEvent>)
                            contextClosedEvent ->
                                    aDockerContainer.stop());
        }
    }
}
