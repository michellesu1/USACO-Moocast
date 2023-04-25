# USACO Moocast
 
<details>
    <summary> Problem Statement </summary>    
    Farmer John's N
 cows (1≤N≤200
) want to organize an emergency "moo-cast" system for broadcasting important messages among themselves.
Instead of mooing at each-other over long distances, the cows decide to equip themselves with walkie-talkies, one for each cow. These walkie-talkies each have a limited transmission radius -- a walkie-talkie of power P
 can only transmit to other cows up to a distance of P
 away (note that cow A might be able to transmit to cow B even if cow B cannot transmit back, due to cow A's power being larger than that of cow B). Fortunately, cows can relay messages to one-another along a path consisting of several hops, so it is not necessary for every cow to be able to transmit directly to every other cow.

Due to the asymmetrical nature of the walkie-talkie transmission, broadcasts from some cows may be more effective than from other cows in their ability to reach large numbers of recipients (taking relaying into account). Please help the cows determine the maximum number of cows that can be reached by a broadcast originating from a single cow.

INPUT FORMAT (file moocast.in):
The first line of input contains N
.
The next N
 lines each contain the x
 and y
 coordinates of a single cow ( integers in the range 0…25,000
) followed by p
, the power of the walkie-talkie held by this cow.

OUTPUT FORMAT (file moocast.out):
Write a single line of output containing the maximum number of cows a broadcast from a single cow can reach. The originating cow is included in this number.
</details>

[Full problem statement](http://www.usaco.org/index.php?page=viewproblem2&cpid=668)

- See moocast.java for the source code.
- Each cow can represent a vertex of a graph. For each cow, I determined which cows the cow can reach and created adjacency lists. I then implemented recursive depth-first-search to traverse the graph to determine the number connected vertices to each vertex.
- My solution's time complexity is O(N*(N+E)), where E is the number of edges.
