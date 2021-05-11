package core.utilities;

import org.openqa.selenium.By;


public class ElementProperties {

	// Key compulsary element properties
	private By ByLocatator;
	private String ColumnName;
	private String ClassName = "NOT_SPECIFIED";
	private String Description;
	private ElementTypes ElementType;

	// Additional element properites.
	private String Iframe = "";
	private By AdditionalLocator;

	// ******************
	// ***Constructors***
	// ******************

	/**
	 * @param ByLocatar
	 * @param Description
	 * @param EleType
	 */
	public ElementProperties(By ByLocatar, String Description, ElementTypes EleType) {
		this.ByLocatator = ByLocatar;
		this.Description = Description;
		this.ElementType = EleType;
	}

	/**
	 * @param ByLocatar
	 * @param Description
	 * @param EleType
	 */
	public ElementProperties(By ByLocatar, String Description, ElementTypes EleType, String Iframe) {
		this.ByLocatator = ByLocatar;
		this.Description = Description;
		this.ElementType = EleType;
		this.Iframe = Iframe;
	}

	/**
	 * @param ByLocatar
	 * @param Description
	 * @param EleType
	 */
	public ElementProperties(By ByLocatar, String Description, ElementTypes EleType, String ColumnName, String Iframe) {
		this.ByLocatator = ByLocatar;
		this.Description = Description;
		this.ElementType = EleType;
		this.ColumnName = ColumnName;
		this.Iframe = Iframe;
	}

	/**
	 * @param ByLocatar
	 * @param Description
	 * @param EleType
	 */
	public ElementProperties(By ByLocatar, String Description, String ClassName, String Iframe, ElementTypes EleType) {
		this.ByLocatator = ByLocatar;
		this.Description = Description;
		this.ClassName = ClassName;
		this.Iframe = Iframe;
		this.ElementType = EleType;

	}

	/**
	 * @param ByLocatar
	 * @param Description
	 * @param EleType
	 */
	public ElementProperties(By ByLocatar, String Description, ElementTypes EleType, String[] Iframe) {
		this.ByLocatator = ByLocatar;
		this.Description = Description;
		this.ElementType = EleType;

		for (int frameNum = 0; frameNum < Iframe.length; frameNum++) {
			if (frameNum == 0) {
				this.Iframe = Iframe[frameNum];
			} else {
				this.Iframe = this.Iframe + "|" + Iframe[frameNum];
			}
		}
	}

	/**
	 * @param ByLocatar
	 * @param Description
	 * @param EleType
	 */
	public ElementProperties(By ByLocatar, String Description, ElementTypes EleType, String ColumnName,
			String[] Iframe) {
		this.ByLocatator = ByLocatar;
		this.Description = Description;
		this.ElementType = EleType;
		this.ColumnName = ColumnName;
		for (int frameNum = 0; frameNum < Iframe.length; frameNum++) {
			if (frameNum == 0) {
				this.Iframe = Iframe[frameNum];
			} else {
				this.Iframe = this.Iframe + "|" + Iframe[frameNum];
			}
		}
	}

	/**
	 * @param ByLocatar
	 * @param Description
	 * @param ColumnName
	 * @param EleType
	 */
	public ElementProperties(By ByLocatar, String Description, String ColumnName, ElementTypes EleType) {
		this.ByLocatator = ByLocatar;
		this.Description = Description;
		this.ColumnName = ColumnName;
		this.ElementType = EleType;
	}

	/**
	 * @param ByLocatar
	 * @param Description
	 * @param ColumnName
	 * @param EleType
	 * @param AdditionalLocator
	 */
	public ElementProperties(By ByLocatar, String Description, String ColumnName, ElementTypes EleType,
			By AdditionalLocator) {
		this.ByLocatator = ByLocatar;
		this.Description = Description;
		this.ColumnName = ColumnName;
		this.ElementType = EleType;
		this.AdditionalLocator = AdditionalLocator;
	}

	// ************************
	// ***setter and Getters***
	// ************************

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	/**
	 * @param ByLocatator the ByLocatator to set
	 */
	public void setByLocatator(By ByLocatator) {
		this.ByLocatator = ByLocatator;
	}

	public void setIframeXpath(String IframeXpath) {
		Iframe = IframeXpath;
	}

	public String getIframeXpath() {
		return Iframe;
	}

	public By getAdditionalLocator() {
		return AdditionalLocator;
	}

	public By getLocator() {
		return ByLocatator;
	}

	public String getDescription() {
		return Description;
	}

	public ElementTypes getElementType() {
		return ElementType;
	}

}
