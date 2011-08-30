/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package be.edu.fundp.precise.bpel_ui.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>User Event Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see be.edu.fundp.precise.bpel_ui.model.ModelPackage#getUserEventType()
 * @model
 * @generated
 */
public enum UserEventType implements Enumerator {
	/**
	 * The '<em><b>On Data Input</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_DATA_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	ON_DATA_INPUT(0, "onDataInput", "onDataInput"),

	/**
	 * The '<em><b>On Data Selection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_DATA_SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	ON_DATA_SELECTION(1, "onDataSelection", "onDataSelection"),

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
	 * The '<em><b>On Erroneous Interaction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_ERRONEOUS_INTERACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ON_ERRONEOUS_INTERACTION(3, "onErroneousInteraction", "onErroneousInteraction"),

	/**
	 * The '<em><b>On Implicite Interaction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ON_IMPLICITE_INTERACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ON_IMPLICITE_INTERACTION(4, "onImpliciteInteraction", "onImpliciteInteraction");

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
	public static final int ON_DATA_INPUT_VALUE = 0;

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
	public static final int ON_DATA_SELECTION_VALUE = 1;

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
	 * The '<em><b>On Erroneous Interaction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Erroneous Interaction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_ERRONEOUS_INTERACTION
	 * @model name="onErroneousInteraction"
	 * @generated
	 * @ordered
	 */
	public static final int ON_ERRONEOUS_INTERACTION_VALUE = 3;

	/**
	 * The '<em><b>On Implicite Interaction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>On Implicite Interaction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ON_IMPLICITE_INTERACTION
	 * @model name="onImpliciteInteraction"
	 * @generated
	 * @ordered
	 */
	public static final int ON_IMPLICITE_INTERACTION_VALUE = 4;

	/**
	 * An array of all the '<em><b>User Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UserEventType[] VALUES_ARRAY =
		new UserEventType[] {
			ON_DATA_INPUT,
			ON_DATA_SELECTION,
			ON_DATA_OUTPUT,
			ON_ERRONEOUS_INTERACTION,
			ON_IMPLICITE_INTERACTION,
		};

	/**
	 * A public read-only list of all the '<em><b>User Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UserEventType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>User Event Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserEventType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UserEventType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>User Event Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserEventType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UserEventType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>User Event Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserEventType get(int value) {
		switch (value) {
			case ON_DATA_INPUT_VALUE: return ON_DATA_INPUT;
			case ON_DATA_SELECTION_VALUE: return ON_DATA_SELECTION;
			case ON_DATA_OUTPUT_VALUE: return ON_DATA_OUTPUT;
			case ON_ERRONEOUS_INTERACTION_VALUE: return ON_ERRONEOUS_INTERACTION;
			case ON_IMPLICITE_INTERACTION_VALUE: return ON_IMPLICITE_INTERACTION;
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
	private UserEventType(int value, String name, String literal) {
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
	
} //UserEventType
