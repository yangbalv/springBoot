package com.springboot.personalLearning.polymorphic.actions.abstractaction;

import com.springboot.personalLearning.polymorphic.actions.action.PersonAction;

public interface SingerAction extends PersonAction {
    void sing(String song);
}
