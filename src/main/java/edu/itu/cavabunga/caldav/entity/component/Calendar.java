package edu.itu.cavabunga.caldav.entity.component;

import edu.itu.cavabunga.caldav.entity.Component;

import javax.persistence.Entity;

@Entity
public class Calendar extends Component {
    public Calendar(){
        this.setComponentType(ComponentType.CALENDAR.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
