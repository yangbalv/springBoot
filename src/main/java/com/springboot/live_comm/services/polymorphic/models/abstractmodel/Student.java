package com.springboot.live_comm.services.polymorphic.models.abstractmodel;

import com.springboot.live_comm.services.polymorphic.actions.PersonAction;
import com.springboot.live_comm.services.polymorphic.actions.SportAction;

public abstract class Student implements PersonAction, SportAction {

}
