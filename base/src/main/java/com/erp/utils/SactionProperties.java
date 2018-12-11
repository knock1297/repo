package com.erp.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

import org.springframework.stereotype.Service;

@Service(value="sactionProperties")
public class SactionProperties {  //extends File implements Cloneable {

  //private static final long serialVersionUID = 1L;
  private Hashtable sections_;
  private String line_;
  protected String filename_;

  public void readFile(String filename) throws Exception {

	 BufferedReader dis = null;
	 line_ = "";
	 try {
	  dis = new BufferedReader(new InputStreamReader( getClass().getClassLoader().getResourceAsStream(filename)));
	  sections_ = new Hashtable();
	  for(line_ = dis.readLine(); line_!=null; ) {
	   while(line_!=null&&!line_.startsWith("["))
	    line_ = dis.readLine();
	    readSection(dis);
	  }
	 } finally {
	  try {dis.close();} catch (Exception ignored){}
	 }
  }

  private void readSection(BufferedReader _dis) throws Exception {
	 String key = null;
	 String value = null;
	 try {
	   Hashtable hashtable = new Hashtable();
	   String s = line_.substring(1, line_.lastIndexOf(93));
	   for(line_ = _dis.readLine(); line_!=null&&!line_.startsWith("["); line_ = _dis.readLine()) {
	  if(line_!=null&&line_.length()!=0&&!line_.startsWith(";")&&!line_.startsWith("#")) {
	    key = line_.substring(0, line_.indexOf("=")).trim();
	    value = line_.substring(line_.indexOf("=")+1).trim();
	    if(value.startsWith("\"")) {
	   value = value.substring(1);
	   if(value.endsWith("\""))
	     value = value.substring(0, value.length()-1);
	    }
	    hashtable.put(key, value);
	  }
	   }
	   sections_.put(s, hashtable);
	 } catch(Exception e) {
	   throw new Exception("CGIniFile::readSection : error when reading the config file = "
	        +e.toString());
	 }
  }

  public String getValue(String _sec, String _key) throws Exception {
	 if(existsValue(_sec, _key))
	   return(String)((Hashtable)sections_.get(_sec)).get(_key);
	 throw new Exception("Section |"+_sec+"|, value |"+_key+"| missing in config files.");
  }

  public boolean existsValue(String _sec, String _key) {
	  return(sections_.containsKey(_sec)&&((Hashtable)sections_.get(_sec)).containsKey(_key));
  }

  public Hashtable getSection(String _sec) {
	  return(Hashtable)sections_.get(_sec);
  }

  public Hashtable getAll() {
	  return(sections_);
  }
  protected void setAll(Hashtable _section) {
    this.sections_ = _section;
  }

//  public String addValue(String _sec, String _key, String _value) {
//	 if(_sec!=null&&_key!=null&&_sec!=""&&_key!="") {
//	   Hashtable hashtable;
//	   if(!sections_.containsKey(_sec))
//	  sections_.put(_sec, hashtable = new Hashtable());
//	   else
//	  hashtable = (Hashtable)sections_.get(_sec);
//	   return(String)hashtable.put(_key, _value);
//	 } else {
//	   return(null);
//	 }
//  }
//
//  public Enumeration getSectionNames() {
//	  return this.sections_.keys();
//  }

//  public void addSection(String _sec) {
//	 if(!this.existsSection(_sec))
//	   sections_.put(_sec.trim(), new Hashtable());
//  }
//
//  public boolean existsSection(String _sec) {
//	 return _sec!=null &&
//	     !_sec.trim().equals("")
//	     &sections_.containsKey(_sec);
//  }

//  public String removeValue(String _sec, String _key) {
//	 if(!sections_.containsKey(_sec))
//	   return(null);
//	 else
//	   return(String)((Hashtable)sections_.get(_sec)).remove(_key);
//  }
//
//  public void removeKeys(String _sec, String _key) {
//	 if(!sections_.containsKey(_sec))
//	   return;
//	 Hashtable hash = (Hashtable)sections_.get(_sec);
//	 for (Enumeration e=hash.keys(); e.hasMoreElements();) {
//	   String key = (String)e.nextElement();
//	   if (key.startsWith(_key+".")) hash.remove(key);
//	 }
//  }

//  public Hashtable removeSection(String _sec) {
//	  return(Hashtable)sections_.remove(_sec);
//  }
//
//  public Hashtable removeAll() {
//	 Hashtable hashtable = sections_;
//	 sections_ = new Hashtable();
//	 return(hashtable);
//  }
//
//  public Vector getSubValues(String _section, String _keyPattern) throws Exception {
//	 Vector ret = new Vector();
//	 for(Enumeration e = this.getSubKeys(_section, _keyPattern).elements(); e.hasMoreElements(); ) {
//	   ret.addElement(this.getValue(_section, (String)e.nextElement()));
//	 }
//	 return ret;
//  }

//  public Vector getSubKeys(String _section, String _keyPattern) throws Exception {
//	 Hashtable hTable = getSection(_section);
//	 Vector subKeys = new Vector();
//	 for(Enumeration e = hTable.keys(); e.hasMoreElements(); ) {
//	   String key = (String)e.nextElement();
//	   if((key.length()>_keyPattern.length())
//	   &&(key.substring(0, _keyPattern.length()).compareTo(_keyPattern)==0)) {
//	  int keyIndex = key.indexOf(".", _keyPattern.length());
//	  if(keyIndex==-1) {
//	    keyIndex = key.length();
//	  }
//	  String subKey = key.substring(0, keyIndex);
//	  boolean alreadyExist = false;
//	  int i = 0;
//	  while((!alreadyExist)&&(i<subKeys.size())) {
//	    if(subKey.compareTo((String)subKeys.elementAt(i))==0) {
//	   alreadyExist = true;
//	    }
//	    i++;
//	  }
//	  if(!alreadyExist) {
//	    subKeys.addElement(new String(subKey));
//	  }
//	   }
//	 }
//	 return subKeys;
//  }
//  public String getFilename() {
//	  return this.filename_;
//  }
}
