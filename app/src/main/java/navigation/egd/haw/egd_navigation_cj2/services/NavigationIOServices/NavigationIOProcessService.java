package navigation.egd.haw.egd_navigation_cj2.services.NavigationIOServices;
import navigation.egd.haw.egd_navigation_cj2.Interfaces.INavigationIOProcessService;

//Nicola Giaconi
//4-12-17

public class NavigationIOProcessService implements INavigationIOProcessService {
    private boolean isFlowActive = false;
    private boolean userReplied = false;
    private boolean isRouteConfirmed = false;
    private boolean isStepComplete = false;
    private boolean isUserUpdated = false;
    private boolean isUserLost = false;
    private boolean isUserArrived = false;
    private Information myInf;


    //constructor
	public NavigationIOProcessService(String myJSON){
        myInf = new Information(myJSON);
        myInf.prepare();
    }

    void run(){
        /*
        This function handles the flow of information.
        */
        confirmRoute();
        if ( isRouteConfirmed ){
            isFlowActive = true;
        }

        while ( isFlowActive ){
            if( !isUserLost && !isUserArrived ){
                if( !isUserUpdated ){
                    sendStepInfo();
                    isUserUpdated = true;
                }
                checkUserPosition();
                if( isStepComplete ){
                    sendStepCompletedMessage();
                    updateInformation();
                    isUserUpdated = false;
                    isStepComplete = false;
                }
            }
            else if( isUserLost ){
                sendLostMessage();
                isFlowActive = false;
            }
            else if( isUserArrived ){
                sendArrivedMessage();
                isFlowActive = false;
            }
            else{
                sendErrorMessage();
                isFlowActive = false;
            }
        }
    }

    void confirmRoute(){
        /*
        This function asks the user to confirm the route.
        The variables userReplied and isRouteConfirmed are changed through setters by Interface.
        */
        sendInitialInfo();
        while ( !userReplied ){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void checkUserPosition(){
        /*
        This function checks if the user is lost and if the step was completed.
        */
        //Asks for position to location services submodule.
        //Compares position and decides if step is complete or not, and if user is lost or not.
        isUserLost = false;
        isStepComplete = true;
    }

    void terminateFlow(){
        /*
        This function terminates the flow of information. Called by Interface Module.
        */
        isFlowActive = false;
    }


    void replayInfo(){
        /*
        This function resets the flag indicating that the user has already heard the Info.
        Called by Interface Module.
        */
        isUserUpdated = false;
    }

    void sendInitialInfo(){
        /*
        This function sends the initial information to Interface module.
        */
        sendToInterface(myInf.initialInfo);
    }

    void sendStepInfo(){
        /*
        This function sends the step information to Interface module.
        */
        sendToInterface(myInf.stepsList[myInf.currentStep]);
    }

    void sendStepCompletedMessage(){
        /*
        This function sends the step completed message to Interface module.
        */
        sendToInterface(myInf.stepCompletedMessage);
    }

    void updateInformation(){
        /*
        This function updates the current step value.
        */
        myInf.updateStepIndex();
    }

    void sendLostMessage(){
        /*
        This function sends the lost message to Interface module.
        */
        sendToInterface(myInf.lostMessage);
    }

    void sendArrivedMessage(){
        /*
        This function sends the arrived message to Interface module.
        */
        sendToInterface(myInf.arrivedMessage);
    }

    void sendErrorMessage(){
        /*
        This function sends the error message to Interface module.
        */
        sendToInterface(myInf.errorMessage);
    }

    void sendToInterface(String toSend){
        /*
        This function sends the input string to the Interface module.
        */
        //To be implemented with Interface Team
    }

    class Information{
        /*
        This class stores the JSON-file information and makes it available to the outer class.
        */

        private String myJSON;
        private String initialInfo;
        private String arrivedMessage = "You have reached your final destination.";
        private String lostMessage = "You are not anymore on course. Please perform a new query.";
        private String errorMessage = "Something went wrong, sorry. Please perform a new query.";
        private String stepCompletedMessage = "You completed your current step.";
        private int currentStep = 0;
        private String[] stepsList;
        private String[] stepsDistance;
        private String[] stepsDuration;
        private double[][] geoCoordinates;

        public Information(String myJSON){
            /*
            Class constructor
             */
            this.myJSON = myJSON;
        }

        void prepare(){
            /*
			This function fills in the all the variables with values from JSON-file.
			*/
        }

        void updateStepIndex(){
		    /*
            This function updates the index of the current step.
            */
            if (stepsList.length <= currentStep +1){
                sendErrorMessage();
                isFlowActive = false;
            }
            else{
                ++currentStep;
            }
        }

    }
}
