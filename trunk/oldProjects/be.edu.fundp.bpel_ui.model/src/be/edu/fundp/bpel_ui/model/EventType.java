/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.bpel_ui.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Event Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see be.edu.fundp.bpel_ui.model.ModelPackage#getEventType()
 * @model
 * @generated
 */
public enum EventType implements Enumerator {
	/**
	 * The '<em><b>On Data Input</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_DATA_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	ON_DATA_INPUT(1, "onDataInput", "onDataInput"),

	/**
	 * The '<em><b>On Data Output</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_DATA_OUTPUT_VALUE
	 * @generated
	 * @ordered
	 */
	ON_DATA_OUTPUT(2, "onDataOutput", "onDataOutput"),

	/**
	 * The '<em><b>On Data Selection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_DATA_SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	ON_DATA_SELECTION(3, "onDataSelection", "onDataSelection"),

	/**
	 * The '<em><b>On Decision Interaction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_DECISION_INTERACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ON_DECISION_INTERACTION(4, "onDecisionInteraction", "onDecisionInteraction"),

	/**
	 * The '<em><b>On Implicit Interacion</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_IMPLICIT_INTERACION_VALUE
	 * @generated
	 * @ordered
	 */
	ON_IMPLICIT_INTERACION(5, "onImplicitInteracion", "onImplicitInteracion");

	/**
	 * The '<em><b>On Data Input</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Data Input</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_DATA_INPUT
	 * @model name="onDataInput"
	 * @generated
	 * @ordered
	 */
	public static final int ON_DATA_INPUT_VALUE = 1;

	/**
	 * The '<em><b>On Data Output</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Data Output</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_DATA_OUTPUT
	 * @model name="onDataOutput"
	 * @generated
	 * @ordered
	 */
	public static final int ON_DATA_OUTPUT_VALUE = 2;

	/**
	 * The '<em><b>On Data Selection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Data Selection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_DATA_SELECTION
	 * @model name="onDataSelection"
	 * @generated
	 * @ordered
	 */
	public static final int ON_DATA_SELECTION_VALUE = 3;

	/**
	 * The '<em><b>On Decision Interaction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Decision Interaction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_DECISION_INTERACTION
	 * @model name="onDecisionInteraction"
	 * @generated
	 * @ordered
	 */
	public static final int ON_DECISION_INTERACTION_VALUE = 4;

	/**
	 * The '<em><b>On Implicit Interacion</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Implicit Interacion</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_IMPLICIT_INTERACION
	 * @model name="onImplicitInteracion"
	 * @generated
	 * @ordered
	 */
	public static final int ON_IMPLICIT_INTERACION_VALUE = 5;

	/**
	 * An array of all the '<em><b>Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EventType[] VALUES_ARRAY =
		new EventType[] {
			ON_DATA_INPUT,
			ON_DATA_OUTPUT,
			ON_DATA_SELECTION,
			ON_DECISION_INTERACTION,
			ON_IMPLICIT_INTERACION,
		};

	/**
	 * A public read-only list of all the '<em><b>Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EventType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType get(int value) {
		switch (value) {
			case ON_DATA_INPUT_VALUE: return ON_DATA_INPUT;
			case ON_DATA_OUTPUT_VALUE: return ON_DATA_OUTPUT;
			case ON_DATA_SELECTION_VALUE: return ON_DATA_SELECTION;
			case ON_DECISION_INTERACTION_VALUE: return ON_DECISION_INTERACTION;
			case ON_IMPLICIT_INTERACION_VALUE: return ON_IMPLICIT_INTERACION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EventType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EventType
