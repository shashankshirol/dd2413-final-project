package furhatos.app.newskill.flow.main

import furhatos.app.newskill.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.nlu.common.TellName
import furhatos.records.Location

val Greeting: State = state(Parent) {

    onButton("Yes"){
        furhat.say("Yes")
    }
    onButton("No"){
        furhat.say("No")
    }
    onButton("Oh Sorry"){
        furhat.say("Oh Sorry.")
    }

    onButton("Look at the paper and explain"){
        val location = Location(-1.0, -1.0, 1.0)
        furhat.attend(location)
        furhat.say("Look at that paper and read through the instructions, don't move it though. Let me know when you are done!")
    }

    onButton("Attend User"){
        furhat.attend(users.current)
    }

    onButton("Tell user to read example"){
        furhat.say("If you don't understand, read through the example there.")
    }

    onButton("Start Game"){
        furhat.say("We will play the Ultimatum game for 6 rounds. You are the Proposer for the first round.")
    }

    onButton("User's turn"){
        random(
            {furhat.say("It's your turn now.")},
            {furhat.say("You go now.")},
            {furhat.say("Now you.")}
        )
    }

    onButton("Do you accept?"){
        furhat.say("Do you accept the offer?")
    }

    onButton("Round over"){
        random(
            {   furhat.say("That concludes this round.") },
            {   furhat.say("That's it for this round.") },
            {   furhat.say("Onto the next round.")},
            {   furhat.say("Let's play again.")},
            {   furhat.say("Interesting choice. Now, the next round.")}
        )
    }

    onButton("Round 2"){
        furhat.say("I offer you 500kr.")
    }

    onButton("Round 4"){
        furhat.say("I offer you 400kr.")
    }

    onButton("Round 6"){
        furhat.say("I offer you 250kr.")
    }

    onButton("End"){
        furhat.say("That's it for today. Thanks for playing!")
    }

    onButton("Accept"){

        random(
            {furhat.say("I accept the offer.")},
            {furhat.say("That's a fair split, I accept.")}
        )
        random(
            {furhat.say("Now it's my turn.")},
            {furhat.say("I go now.")},
            {furhat.say("Now me.")}
        )
    }
    onButton("Reject"){
        random(
            {furhat.say("I reject the offer.")},
            {furhat.say("Are you serious?, I reject.")}
        )
        random(
            {furhat.say("Now it's my turn.")},
            {furhat.say("I go now.")},
            {furhat.say("Now me.")}
        )
    }


    onEntry {
        furhat.say("Hello, Human. My name is Furhat.")
        furhat.say("What is your name?")
    }


    onUserLeave {
        furhat.say("Goodbye!")
        goto(Idle)
    }
}


val Game:State = state(Parent){

}

val Offer: State = state(Parent){
    onButton("Accept"){
        furhat.say("I accept the offer.")
    }
    onButton("Reject"){
        furhat.say("I reject the offer")
    }
}

