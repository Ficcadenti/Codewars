//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.08.03 alle 11:48:56 AM CEST 
//


package it.sogei.architecture.microprofile.server.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dtEmissione" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="idCassa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pIva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numScontr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matricolaRt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dtEmissione",
    "idCassa",
    "pIva",
    "personId",
    "numScontr",
    "matricolaRt"
})
@XmlRootElement(name = "CorrispettivoIdIn")
public class CorrispettivoIdIn {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtEmissione;
    protected String idCassa;
    @XmlElement(required = true)
    protected String pIva;
    @XmlElement(required = true)
    protected String personId;
    protected String numScontr;
    protected String matricolaRt;

    /**
     * Recupera il valore della proprietà dtEmissione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtEmissione() {
        return dtEmissione;
    }

    /**
     * Imposta il valore della proprietà dtEmissione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtEmissione(XMLGregorianCalendar value) {
        this.dtEmissione = value;
    }

    /**
     * Recupera il valore della proprietà idCassa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCassa() {
        return idCassa;
    }

    /**
     * Imposta il valore della proprietà idCassa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCassa(String value) {
        this.idCassa = value;
    }

    /**
     * Recupera il valore della proprietà pIva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIva() {
        return pIva;
    }

    /**
     * Imposta il valore della proprietà pIva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIva(String value) {
        this.pIva = value;
    }

    /**
     * Recupera il valore della proprietà personId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * Imposta il valore della proprietà personId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonId(String value) {
        this.personId = value;
    }

    /**
     * Recupera il valore della proprietà numScontr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumScontr() {
        return numScontr;
    }

    /**
     * Imposta il valore della proprietà numScontr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumScontr(String value) {
        this.numScontr = value;
    }

    /**
     * Recupera il valore della proprietà matricolaRt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaRt() {
        return matricolaRt;
    }

    /**
     * Imposta il valore della proprietà matricolaRt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaRt(String value) {
        this.matricolaRt = value;
    }

}
