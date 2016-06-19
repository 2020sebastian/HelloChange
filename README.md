# HelloChange

Description:
Mock cash register which accepts bills of the following denominations: $20, $10, $5, $2, $1

Runnable via command line, interacts with user via commands like:

$> show                                 - shows current state iand each denomination
$> put <int> <int> <int> <int> <int>    - put bills denomination: $20 $10 $5 $2 $1
$> take <int> <int> <int> <int> <int>   - take bills denomination: $20 $10 $5 $2 $1
$> change <int>                         - will remove that amount from the register
$> quit                                 - will exit the program
$> help                                 - will show this commands


The algorithm it uses is a hybrid between a greedy and a recursive one.

This algorithm starts out in an iterative way trying to return change using the largest bills first
If it does not succeed, and there are multiple bills available of several kinds it will remove one bill from the
largest pile and will recurse with that input until it finds a good combination.

Tests for the algorithm are in OptimalChangeTest.java