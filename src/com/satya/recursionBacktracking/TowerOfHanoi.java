package com.satya.recursionBacktracking;

/**
 * Tower of Hanoi is a mathematical puzzle where we have three poles and n disks.
 * The objective of the puzzle is to move the entire stack to another poles, obeying the following simple rules:
 *
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and placing it on top of another
 * stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 *
 * Example of 2 disks :
 *  pole 1 = A, pole 2 = B, pole 3 = C.
 *
 * 1) Shift 1st disk from A to B
 * 2) Shift 2nd disk from A to C
 * 3) Shift 1st disk from B to C
 *
 * The pattern  :
 * 1) Shift n-1 disks from A to B
 * 2) Shift last disk from A to C
 * 3) Shift n-1 disks from B to C
 *
 */
public class TowerOfHanoi {
    public static void move(int disk,char srcPole,char targetPole,char helperPole){
        if(disk==1){
            System.out.println("Moved disk "+disk+"  from "+srcPole+", to "+targetPole+", using:"+helperPole);
        }
        //Move n-1 disk from src to target using helper pole.( Here helper becomes target and target becomes helper)
        move(disk-1,srcPole,helperPole,targetPole);
        System.out.println("Moved disk "+disk+"  from "+srcPole+", to "+targetPole+", using:"+helperPole);
        //after the single disk is migrated. Move the n-1 disc to the final pole where largest disk is present
        move(disk-1,helperPole,targetPole,srcPole);
    }
}
