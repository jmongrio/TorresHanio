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

`for (int x = Objetivo; x >= 1; x--) {

                Nodo Plataforma = new Nodo();

                String Disco = "";

                for (int y = x; y > 0; y--) {
                    Disco += "#";
                }

                Plataforma.setDato(Disco);

                pilaTorreA.Push(Plataforma);
                
            }`
