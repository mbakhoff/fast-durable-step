package com.zeroturnaround.faststep;

import org.jenkinsci.plugins.durabletask.executors.ContinuedTask;

import hudson.Extension;
import hudson.ExtensionComponent;
import jenkins.ExtensionFilter;

@Extension
public class SchedulerFilter extends ExtensionFilter {

  @Override
  public <T> boolean allows(Class<T> type, ExtensionComponent<T> component) {
    // ContinuedTask$Scheduler is dead slow when the queue is large
    // it doesn't seem to be critical for anything, just an optimization
    return !(component.getInstance() instanceof ContinuedTask.Scheduler);
  }
}
