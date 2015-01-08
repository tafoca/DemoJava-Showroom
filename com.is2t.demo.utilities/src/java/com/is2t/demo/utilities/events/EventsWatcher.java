/*
 * Java
 *
 * Copyright 2014 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package com.is2t.demo.utilities.events;

import java.lang.ref.WeakReference;
import java.util.List;

import com.is2t.demo.utilities.errors.ErrorHandler;

import ej.microui.EventGenerator;

public interface EventsWatcher {

	/**
	 * Gets all available event generators.
	 * 
	 * @see EventGenerator#get(Class)
	 * @return the list of generators.
	 */
	List<EventGenerator> getAllGenerators();

	/**
	 * Watches the events generated by an event generator.
	 * <p>
	 * All events generated by the given generator will be sent to the event handler.
	 * <p>
	 * Reference to the event handler is weak.
	 * 
	 * @param eventGenerator
	 *            the event generator to watch.
	 * @param eventHandler
	 *            the event handler to send the event to.
	 * @see WeakReference
	 */
	void watch(EventGenerator eventGenerator, EventHandler eventHandler);

	/**
	 * Watches the events generated by a set of event generators.
	 * 
	 * @param eventGenerators
	 *            the event generators to watch.
	 * @param eventHandler
	 *            the event handler to send the event to.
	 * @see #watch(EventGenerator, EventHandler)
	 */
	void watchAll(List<EventGenerator> eventGenerators, EventHandler eventHandler);

	/**
	 * Captures the events generated by an event generator.
	 * <p>
	 * All events generated by the given generator will be sent to the event handler.
	 * <p>
	 * The captured events will not be propagated to the original listener of the event generator (or the previous
	 * capture event handler).
	 * <p>
	 * Reference to the event handler is weak.
	 * 
	 * @param eventGenerator
	 *            the event generator to capture.
	 * @param eventHandler
	 *            the event handler to send the event to.
	 * @see WeakReference
	 */
	void capture(EventGenerator eventGenerator, EventHandler eventHandler);

	void uncapture(EventHandler eventHandler);
	
	void unwatch(EventHandler eventHandler);
	
	/**
	 * Captures the events generated by an event generator.
	 * 
	 * @param eventGenerators
	 *            the event generators to capture.
	 * @param eventHandler
	 *            the event handler to send the event to.
	 * @see #capture(EventGenerator, EventHandler)
	 */
	void captureAll(List<EventGenerator> eventGenerators, EventHandler eventHandler);

	/**
	 * Sets an error handler that will receive all uncaught exceptions generated by the event handlers.
	 * 
	 * @param errorHandler
	 *            the error handler to set.
	 */
	void setErrorHandler(ErrorHandler errorHandler);

}