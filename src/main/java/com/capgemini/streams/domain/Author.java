////////////////////////////////////////////////////////////////////
//
// File: Author.java
// Created: 17-07-18 09:32
// Author: FJM575 (Raphael Themans)
// Electrabel n.v./s.a., Regentlaan 8 Boulevard du Régent, BTW BE 0403.107.701 - 1000 Brussel/Bruxelles, Belgium.
//
// Proprietary Notice:
// This software is the confidential and proprietary information of Electrabel s.a./n.v. and/or its licensors. 
// You shall not disclose this Confidential Information to any third parties
// and any use thereof shall be subject to the terms and conditions of use, as agreed upon with Electrabel in writing.
//
////////////////////////////////////////////////////////////////////
package com.capgemini.streams.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

/**
 * @author FJM575 (Raphael Themans)
 */
public class Author {
    private String name;
    private LocalDate birthDate;
    private Optional<LocalDate> deathDate = Optional.empty();
    private String country;
    private Locale language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isDead() {
        return deathDate.isPresent();
    }

    public Optional<LocalDate> getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = Optional.of(deathDate);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return new EqualsBuilder()
                .append(getName(), author.getName())
                .append(getBirthDate(), author.getBirthDate())
                .append(getDeathDate(), author.getDeathDate())
                .append(getCountry(), author.getCountry())
                .append(getLanguage(), author.getLanguage())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .append(getBirthDate())
                .append(getDeathDate())
                .append(getCountry())
                .append(getLanguage())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("birthDate", birthDate)
                .append("deathDate", deathDate)
                .append("country", country)
                .append("language", language)
                .toString();
    }
}
