
# Blur Console

Blur Console is a tool built to help visualize that status of an Apache Blur (Incubator) cluster.  The tool contains information about node status, table status, and query status.  The tool also has a built in search page to quickly search and retrieve records and rows from Apache Blur.

## Development Setup

The development for this tool is done in two pieces the UI (Javascript) and the services (Java).  The services piece contains and encapsulates all of the connections and requests into Apache Blur.  The services piece is also responsible for starting a webserver and serving the static UI resources.  The structure of this component allows for the UI and services to be worked on independently and then both can be packaged together for one distribution.

In order to contribute to the development of this component the following tools/languages will need to be available:

* Java
* Node (0.10.x or higher) - This will come with npm

### UI Development

To turn on the development profile:
export BLUR_CONSOLE_DEV=true

The UI code lives in the srce/main/webapp directory.  This directory has been setup like a standard javascript based application would be.  The goal of this is to allow for rapid development of the UI components while flushing out the service API.  The UI portion has been built so that the system can be run with fake data to mock out the actual Apache Blur integration.

To get up and running to work on the UI component you can follow these steps:

1. Install grunt-cli (node build manager)

		npm install -g grunt-cli

2. Install project build/test dependencies (from the src/main/webapp directory)
		
		npm install

Once the dependencies and build tools are installed the following commands can be used (from the src/main/webapp directory):

* Run tests
		
		grunt test:unit

* Start development server (server will be available on port 3000)
		
		grunt serve

### Services Development

The services code lives at the root of the console directory and is a basic maven project.
