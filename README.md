# event-listener
This application register events, matches them against a validation schema and if valid sends them to a Kafka Topic.

This is an MVP - Minimum viable product so there is room for improvement

Future improvements:
- Validation schemas will be loaded from an external system, such as zookeeper
- Endpoint URI will be configurable: `/input/1` will be replaced with a configurable `/input/${id}` so we can start this service in multiple instances with different endpoints for each
- Refactoring: Controllers will be refactored and AOP will be used to reduce boilerplate: exception handling will be done by an advisor
