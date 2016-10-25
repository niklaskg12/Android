/*******************************************************************************
 *  Copyright (c) 2010 - 2013 Ushahidi Inc
 *  All rights reserved
 *  Contact: team@ushahidi.com
 *  Website: http://www.ushahidi.com
 *  GNU Lesser General Public License Usage
 *  This file may be used under the terms of the GNU Lesser
 *  General Public License version 3 as published by the Free Software
 *  Foundation and appearing in the file LICENSE.LGPL included in the
 *  packaging of this file. Please review the following information to
 *  ensure the GNU Lesser General Public License version 3 requirements
 *  will be met: http://www.gnu.org/licenses/lgpl.html.
 *
 * If you have questions regarding the use of this file, please contact
 * Ushahidi developers at team@ushahidi.com.
 ******************************************************************************/

package org.addhen.smssync.models;

/**
 * Information about the status of the phone
 */
public class PhoneStatusInfo {

    private String mPhoneNumber;

    private boolean mDataConnection;

    public int getBatteryLevel() {
        return mBatteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        mBatteryLevel = batteryLevel;
    }

    private int mBatteryLevel;

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }

    public boolean isDataConnection() {
        return mDataConnection;
    }

    public void setDataConnection(boolean dataConnection) {
        this.mDataConnection = dataConnection;
    }

    @Override
    public String toString() {
        return "PhoneStatusInfo{" +
                "mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mDataConnection=" + mDataConnection +
                ", mBatteryLevel=" + mBatteryLevel +
                '}';
    }
}
