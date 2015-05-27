# NCH Bootcamp #
##Prerequisites##
###Accounts###
Each new hire will need to set up the following accounts to start the lab content provided in this repository.

* Red Hat Access Portal Account (https://access.redhat.com)
* An OpenShift Online Account (https://www.openshift.com/app/account/new -- use your RH email address)

###Installations###
Each new hire will need the following installations downloaded and unzipped prior to the start of the New Hire Bootcamp.

Install | URL
-------- | ----------
Java Development Kit 7 | [OpenJDK](http://openjdk.java.net/install/), [Oracle JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
Apache Maven (Latest) | [link](http://maven.apache.org/download.cgi)
JBoss EAP 6.4.0 | [link](https://access.redhat.com/jbossnetwork/restricted/listSoftware.html?downloadType=distributions&product=appplatform&version=6.1.0&productChanged=yes)
JBoss BPM Suite 6.1.0 | [link](https://access.redhat.com/jbossnetwork/restricted/listSoftware.html?downloadType=distributions&product=bpm.suite&productChanged=yes)

##Day 1 - OpenShift Application Management##
1. Install OpenShift command line tools -- follow the instructions [here](https://developers.openshift.com/en/managing-client-tools.html)
2. Run the following on the command line to create a BPM Suite project in OpenShift:

<code>$ rhc create-app -g medium bpmsuite https://raw.githubusercontent.com/jboss-bpms/openshift-cartridge-bpms/master/metadata/manifest.yml</code>
 * This will output the generated users and passwords for Business Central, which you can use to login into Business Central or BAM applications.


##Day 2 - Business Rules and Process Modeling##

##Day 3 - Integrating Services with Camel##

##Day 4 - Continuous Integration and Delivery##

##Day 5 - To Infinity and Beyond##

