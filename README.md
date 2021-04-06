# Towers of Hanoy
An exercise of "towers of Hanoy"

## Table of Contents
* [Explanation](#Explanation)
* [Restrictions](#Restrictions)
* [Algorithm](#Algorithm)

## Explanation
* Towers of Hanoy is a game-puzzle where you are supposed to solve the riddle of moving disk under certian restrictions, from one pin to another. 
It is also a programming execise designed to teach the use of simple data structures in arrays and simple objects, used as mere structs.

## Restrictions
1. Only one disk may be moved at a time.
2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.
3. No disk may be placed on top of a disk which is smaller than it.

## Algorithm

`
A = [3, 2, 1]
B = []
C = []

def move(n, source, target, auxiliary):
    if n > 0:
        # Move n - 1 disks from source to auxiliary, so they are out of the way
        move(n - 1, source, auxiliary, target)

        # Move the nth disk from source to target
        target.append(source.pop())

        # Display our progress
        print(A, B, C, '##############', sep='\n')

        # Move the n - 1 disks that we left on auxiliary onto target
        move(n - 1, auxiliary, target, source)

# Initiate call from source A to target C with auxiliary B
move(3, A, C, B)
`
