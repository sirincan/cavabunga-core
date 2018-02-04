package edu.itu.cavabunga.core.services;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.parameter.ParameterType;
import edu.itu.cavabunga.core.entity.property.PropertyType;
import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.factory.ParameterFactory;
import edu.itu.cavabunga.core.factory.PropertyFactory;
import edu.itu.cavabunga.core.repository.ComponentRepository;
import edu.itu.cavabunga.core.repository.ParameterRepository;
import edu.itu.cavabunga.core.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IcalServiceImpl {
    @Autowired
    public ParticipantServiceImpl participantServiceImpl;

    @Autowired
    public ComponentFactory componentFactory;

    @Autowired
    public ComponentRepository componentRepository;

    @Autowired
    public PropertyFactory propertyFactory;

    @Autowired
    public PropertyRepository propertyRepository;

    @Autowired
    public ParameterFactory parameterFactory;

    @Autowired
    public ParameterRepository parameterRepository;

    public Component createComponent(ComponentType componentType){
        return componentFactory.createComponent(componentType);
    }

    public Component createComponentForParticipant(ComponentType componentType, Participant participant){
        Component result = componentFactory.createComponent(componentType);
        result.setOwner(participant);
        return result;
    }

    public Component getComponentById(Long id){
        return componentRepository.findOne(id);
    }

    public List<Component> getComponentByParticipant(Participant participant){
        return componentRepository.findByOwner(participant);
    }

    public List<Component> getAllSpecificComponent(ComponentType componentType){
        return componentRepository.findByType(componentType.toString());
    }

    public List<Component> getComponentByParticipantAndType(Participant participant, ComponentType componentType){
        return componentRepository.findByOwnerAndType(participant, componentType.toString());
    }

    public Iterable<Component> getAllComponent(){
        return componentRepository.findAll();
    }

    public void saveComponent(Component component){
        componentRepository.save(component);
    }

    public Property createProperty(PropertyType propertyType){
       return  propertyFactory.createProperty(propertyType);
    }

    public Property getPropertyById(Long id){
        return propertyRepository.findOne(id);
    }

    public List<Property> getPropertyByComponent(Component component){
         return propertyRepository.findByComponent(component);
    }

    public List<Property> getAllSpecificProperty(PropertyType propertyType){
        return propertyRepository.findByType(propertyType.toString());
    }

    public List<Property> getPropertyByComponentAndType(Component component, PropertyType propertyType){
        return propertyRepository.findByComponentAndType(component, propertyType.toString());
    }

    public Iterable<Property> getAllProperty(){
        return propertyRepository.findAll();
    }

    public Parameter createParameter(ParameterType parameterType){
        return parameterFactory.createParameter(parameterType);
    }



    public Parameter createParameterForProperty(ParameterType parameterType, Property property){
        Parameter result = parameterFactory.createParameter(parameterType);
        result.setProperty(property);
        return result;
    }
}