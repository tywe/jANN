/**
 * Projekt ANNtool 
 *
 * Copyright (c) 2011 github.com/timaschew/jANN
 * 
 * anton
 */
package de.unikassel.ann.controller;

/**
 * @author anton
 * 
 */
public enum Actions {
	// Test Actions
	TEST_UPDATEVIEW, TEST_UPDATEMODEL, TEST_NETWORK,

	// Menu Actions
	NONE, IMPORT, CLOSE_CURRENT_SESSION, IMPORT_RECENT, EXPORT, NEW, SAVE, EXIT, VIEW_DATA, VIEW_TRAINING, ABOUT, BACKPROPAGATION_VIEW, SOM_VIEW, NORMALIZE_TRAIN_DATA,

	// ActionController Update-Events
	UPDATE_SIDEBAR_TOPOLOGY_VIEW, UPDATE_SIDEBAR_CONFIG_INPUT_NEURON_MODEL, UPDATE_SIDEBAR_CONFIG_HIDDEN_NEURON_MODEL, UPDATE_SIDEBAR_CONFIG_HIDDEN_LAYER_MODEL, UPDATE_SIDEBAR_CONFIG_OUTPUT_NEURON_MODEL, UPDATE_JUNG_GRAPH, UPDATE_SIDEBAR_TRAINSTRATEGY_VIEW,
	// Actions
	CREATE_NETWORK, PLAY_TRAINING, CHANGE_MOUSE_MODI, UPDATE_SIDEBAR_CONFIG_INPUT_BIAS_MODEL, UPDATE_SIDEBAR_CONFIG_HIDDEN_BIAS_MODEL, UPDATE_JUNG_GRAPH_INPUT_BIAS, UPDATE_JUNG_GRAPH_HIDDEN_BIAS, SET_THE_STRATEGY,

	// SOM Actions
	UPDATE_SIDEBAR_TOPOLOGYSOM_VIEW, UPDATE_SIDEBAR_TRAINSTRATEGY_LERNRATE_MODEL,

	// Load Example-Networks
	LOAD_OR_NETWORK, LOAD_XOR_NETWORK, LOAD_AND_NETWORK, LOAD_2_BIT_ADDIERER_NETWORK;
}
