package com.puttysoftware.updater;

import java.net.MalformedURLException;
import java.net.URL;

public class ProductData {
    // Fields
    private URL updateURL;
    private URL blurbURL;
    private URL newVersionURL;
    private String rDNSCompanyName;
    private String companyName;
    private String productName;
    private int majorVersion;
    private int minorVersion;
    private int bugfixVersion;
    private int codeVersion;
    private int prereleaseVersion;
    public static final int CODE_PRE_ALPHA = 0;
    public static final int CODE_ALPHA = 1;
    public static final int CODE_BETA = 2;
    public static final int CODE_RELEASE_CANDIDATE = 3;
    public static final int CODE_STABLE = 4;

    // Constructors
    public ProductData() {
        // Do nothing
    }

    public ProductData(final int major, final int minor, final int bugfix,
            final int code, final int beta) {
        this.majorVersion = major;
        this.minorVersion = minor;
        this.bugfixVersion = bugfix;
        this.codeVersion = code;
        this.prereleaseVersion = beta;
    }

    public ProductData(final String update, final String blurb,
            final String newVersion, final String companyMac,
            final String company, final String product, final int major,
            final int minor, final int bugfix, final int code, final int beta) {
        String rt;
        if (code == ProductData.CODE_ALPHA) {
            rt = "alpha_"; //$NON-NLS-1$
        } else if (code == ProductData.CODE_BETA) {
            rt = "beta_"; //$NON-NLS-1$
        } else {
            rt = "stable_"; //$NON-NLS-1$
        }
        final String updatetxt = "version.txt"; //$NON-NLS-1$
        final String blurbtxt = "blurb.txt"; //$NON-NLS-1$
        try {
            this.updateURL = new URL(update + rt + updatetxt);
        } catch (final MalformedURLException mu1) {
            // Ignore
        }
        try {
            this.blurbURL = new URL(blurb + rt + blurbtxt);
        } catch (final MalformedURLException mu1) {
            // Ignore
        }
        try {
            this.newVersionURL = new URL(newVersion);
        } catch (final MalformedURLException mu1) {
            // Ignore
        }
        this.rDNSCompanyName = companyMac;
        this.companyName = company;
        this.productName = product;
        this.majorVersion = major;
        this.minorVersion = minor;
        this.bugfixVersion = bugfix;
        this.codeVersion = code;
        this.prereleaseVersion = beta;
    }

    // Methods
    /**
     * @return the updateURL
     */
    public URL getUpdateURL() {
        return this.updateURL;
    }

    /**
     * @param newUpdateURL
     *            the updateURL to set
     */
    public void setUpdateURL(final URL newUpdateURL) {
        this.updateURL = newUpdateURL;
    }

    /**
     * @return the blurbURL
     */
    public URL getBlurbURL() {
        return this.blurbURL;
    }

    /**
     * @param newBlurbURL
     *            the blurbURL to set
     */
    public void setBlurbURL(final URL newBlurbURL) {
        this.blurbURL = newBlurbURL;
    }

    /**
     * @return the newVersionURL
     */
    public URL getNewVersionURL() {
        return this.newVersionURL;
    }

    /**
     * @param newNewVersionURL
     *            the newVersionURL to set
     */
    public void setNewVersionURL(final URL newNewVersionURL) {
        this.newVersionURL = newNewVersionURL;
    }

    /**
     * @return the rDNSCompanyName
     */
    public String getrDNSCompanyName() {
        return this.rDNSCompanyName;
    }

    /**
     * @param newRDNSCompanyName
     *            the rDNSCompanyName to set
     */
    public void setrDNSCompanyName(final String newRDNSCompanyName) {
        this.rDNSCompanyName = newRDNSCompanyName;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * @param newCompanyName
     *            the companyName to set
     */
    public void setCompanyName(final String newCompanyName) {
        this.companyName = newCompanyName;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * @param newProductName
     *            the productName to set
     */
    public void setProductName(final String newProductName) {
        this.productName = newProductName;
    }

    /**
     * @return the majorVersion
     */
    public int getMajorVersion() {
        return this.majorVersion;
    }

    /**
     * @param newMajorVersion
     *            the majorVersion to set
     */
    public void setMajorVersion(final int newMajorVersion) {
        this.majorVersion = newMajorVersion;
    }

    /**
     * @return the minorVersion
     */
    public int getMinorVersion() {
        return this.minorVersion;
    }

    /**
     * @param newMinorVersion
     *            the minorVersion to set
     */
    public void setMinorVersion(final int newMinorVersion) {
        this.minorVersion = newMinorVersion;
    }

    /**
     * @return the bugfixVersion
     */
    public int getBugfixVersion() {
        return this.bugfixVersion;
    }

    /**
     * @param newBugfixVersion
     *            the bugfixVersion to set
     */
    public void setBugfixVersion(final int newBugfixVersion) {
        this.bugfixVersion = newBugfixVersion;
    }

    /**
     * @return the codeVersion
     */
    public int getCodeVersion() {
        return this.codeVersion;
    }

    /**
     * @param newCodeVersion
     *            the codeVersion to set
     */
    public void setCodeVersion(final int newCodeVersion) {
        this.codeVersion = newCodeVersion;
    }

    /**
     * @return the betaVersion
     */
    public int getPrereleaseVersion() {
        return this.prereleaseVersion;
    }

    /**
     * @param newPrereleaseVersion
     *            the prereleaseVersion to set
     */
    public void setPrereleaseVersion(final int newPrereleaseVersion) {
        this.prereleaseVersion = newPrereleaseVersion;
    }

    public String getReleaseType() {
        String rt;
        if (this.codeVersion == ProductData.CODE_PRE_ALPHA) {
            rt = "dev";
        } else if (this.codeVersion == ProductData.CODE_ALPHA) {
            rt = "alpha";
        } else if (this.codeVersion == ProductData.CODE_BETA) {
            rt = "beta";
        } else if (this.codeVersion == ProductData.CODE_RELEASE_CANDIDATE) {
            rt = "rc";
        } else {
            rt = "";
        }
        return rt;
    }

    public String getVersionString() {
        if (this.isBetaModeEnabled()) {
            String rt;
            if (this.codeVersion == ProductData.CODE_PRE_ALPHA) {
                rt = "-dev";
            } else if (this.codeVersion == ProductData.CODE_ALPHA) {
                rt = "-alpha";
            } else if (this.codeVersion == ProductData.CODE_BETA) {
                rt = "-beta";
            } else if (this.codeVersion == ProductData.CODE_RELEASE_CANDIDATE) {
                rt = "-RC";
            } else {
                rt = "";
            }
            return "" + this.majorVersion + "." + this.minorVersion + "."
                    + this.bugfixVersion + rt + this.prereleaseVersion;
        } else {
            return "" + this.majorVersion + "." + this.minorVersion + "."
                    + this.bugfixVersion;
        }
    }

    public boolean isBetaModeEnabled() {
        return this.codeVersion != ProductData.CODE_STABLE;
    }
}
