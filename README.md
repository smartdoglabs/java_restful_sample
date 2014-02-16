sports
======

Here's the data model for this prorotype:

![Image](../master/flocasts_model.png?raw=true)

And now the basic component model we will use here. The main services to be exposed to the web application and potentially to 3rd party developers are the User, Video, and Event services. The Event service is a bit different than the others in that it will use a message queue for the add event operation. This way this can scale to hander bigger loads. For the first iteration we will not implement the message queueing infrasftructure, but I'll include it in the design.

![Image](../master/sports_component.png?raw=true)

Here are the specs for the RESTful service calls and the HTTP methods they support:

User Service:<br/>
https://api.mydomain.com/users                        GET,POST<br/>
https://api.mydomain.com/users/{id}                   GET<br/>
https://api.mydomain.com/users/{id}/activity          GET<br/>
https://api.mydomain.com/users/{id}/recommendations   GET<br/>

Video Service:<br/>
https://api.mydomain.com/videos               GET,POST<br/>
https://api.mydomain.com/videos/{id}          GET<br/>
https://api.mydomain.com/videos/{id}/activity GET<br/>
https://api.mydomain.com/videos/{id}/stats    GET<br/>
https://api.mydomain.com/videos/{id}/similar  GET<br/>

Event Service:<br/>
https://api.mydomain.com/events               GET,POST<br/>
