# cs322-traffic-proj
The GOATS team's semester project for A. Charlesworth's CMSC 322 course Software Engineering Practicum at University of Richmond

Timeline:
 Mon, Oct. 30: Recommended that members have committed classes
 Wed, Nov. 2: In-class inspection of functional program
 Fri, Nov. 4: Due: Assignment_Related_to_top_level_tester_for_traffic_simulation, 4:45pm.
 
Stage_0
 Apply style rules
 Standardize intersection/lane processing order

Stage_1
 Lanes have a maximum capacity and a minimum number of time intervals for a car to traverse it.
 Inbound and outbound lanes have no maximum capacity and no minimum number of time intervals for a car to traverse them.
 A car leaves the grid as soon as it enters an outbound lane.
 A car initially (upon spawn) has already satisfied the minimum amount of time it needs to spend in a lane before moving)

Stage_2
 Intersections are roundabouts
 Roundabouts have a quarter-length with a maximum capacity and a minimum number of time intervals for traversal.
 Roundabout components get processed in the following order:
   S-E quarter
   S incoming lane
   E-N quarter
   E incoming lane
   N-W quarter
   N incoming lane
   W-S quarter lane
   W incoming lane
   S outgoing lane
   E outgoing lane
   N outgoing lane
   W outgoing lane
