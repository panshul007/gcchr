package com.gcchr.system.core.configuration.akka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import akka.actor.Extension;
import akka.actor.Props;

@Component
public class SpringExtension implements Extension
{
    private ApplicationContext applicationContext;

    @Autowired
    public SpringExtension(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }

    public void initialize(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }

    public Props props(String actorBeanName)
    {
        return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
    }
}
