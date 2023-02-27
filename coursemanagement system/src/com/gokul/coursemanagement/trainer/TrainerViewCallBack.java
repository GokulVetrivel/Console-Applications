package com.gokul.coursemanagement.trainer;

import com.gokul.coursemanagement.dto.Trainer;

public interface TrainerViewCallBack {

	void choiceErrorMsg(String string);

	void trainerMenu(Trainer trainer);

}
