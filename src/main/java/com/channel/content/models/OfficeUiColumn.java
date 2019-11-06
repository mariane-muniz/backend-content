package com.channel.content.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "office_ui_columns")
public class OfficeUiColumn extends AbstractAudit {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", initialValue = 1000)
    private Long id;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false, name = "min_width")
    private int minWidth;

    @Column(nullable = false, name = "is_row_header")
    private boolean isRowHeader;

    @Column(nullable = false, name = "is_resizable")
    private boolean isResizable;

    @Column(nullable = false, name = "is_sorted")
    private boolean isSorted;

    @Column(nullable = false, name = "is_sorted_descending")
    private boolean isSortedDescending;

    @Column(nullable = false, name = "sort_ascending_arial_label")
    private String sortAscendingAriaLabel;

    @Column(nullable = false, name = "sort_descending_arial_label")
    private String sortDescendingAriaLabel;

    @Column(nullable = false, name = "on_column_click")
    private String onColumnClick;

    @Column(nullable = false, name = "ispadded")
    private boolean isPadded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "element_id", nullable = true)
    private Element element;

    public Long getId() {
        return this.id;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public boolean isIsRowHeader() {
        return this.isRowHeader;
    }

    public boolean getIsRowHeader() {
        return this.isRowHeader;
    }

    public void setIsRowHeader(boolean isRowHeader) {
        this.isRowHeader = isRowHeader;
    }

    public boolean isIsResizable() {
        return this.isResizable;
    }

    public boolean getIsResizable() {
        return this.isResizable;
    }

    public void setIsResizable(boolean isResizable) {
        this.isResizable = isResizable;
    }

    public boolean isIsSorted() {
        return this.isSorted;
    }

    public boolean getIsSorted() {
        return this.isSorted;
    }

    public void setIsSorted(boolean isSorted) {
        this.isSorted = isSorted;
    }

    public boolean isIsSortedDescending() {
        return this.isSortedDescending;
    }

    public boolean getIsSortedDescending() {
        return this.isSortedDescending;
    }

    public void setIsSortedDescending(boolean isSortedDescending) {
        this.isSortedDescending = isSortedDescending;
    }

    public String getSortAscendingAriaLabel() {
        return this.sortAscendingAriaLabel;
    }

    public void setSortAscendingAriaLabel(String sortAscendingAriaLabel) {
        this.sortAscendingAriaLabel = sortAscendingAriaLabel;
    }

    public String getSortDescendingAriaLabel() {
        return this.sortDescendingAriaLabel;
    }

    public void setSortDescendingAriaLabel(String sortDescendingAriaLabel) {
        this.sortDescendingAriaLabel = sortDescendingAriaLabel;
    }

    public String getOnColumnClick() {
        return this.onColumnClick;
    }

    public void setOnColumnClick(String onColumnClick) {
        this.onColumnClick = onColumnClick;
    }

    public boolean isIsPadded() {
        return this.isPadded;
    }

    public boolean getIsPadded() {
        return this.isPadded;
    }

    public void setIsPadded(boolean isPadded) {
        this.isPadded = isPadded;
    }

    public OfficeUiColumn key(String key) {
        this.key = key;
        return this;
    }

    public OfficeUiColumn minWidth(int minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    public OfficeUiColumn isRowHeader(boolean isRowHeader) {
        this.isRowHeader = isRowHeader;
        return this;
    }

    public OfficeUiColumn isResizable(boolean isResizable) {
        this.isResizable = isResizable;
        return this;
    }

    public OfficeUiColumn isSorted(boolean isSorted) {
        this.isSorted = isSorted;
        return this;
    }

    public OfficeUiColumn isSortedDescending(boolean isSortedDescending) {
        this.isSortedDescending = isSortedDescending;
        return this;
    }

    public OfficeUiColumn sortAscendingAriaLabel(String sortAscendingAriaLabel) {
        this.sortAscendingAriaLabel = sortAscendingAriaLabel;
        return this;
    }

    public OfficeUiColumn sortDescendingAriaLabel(String sortDescendingAriaLabel) {
        this.sortDescendingAriaLabel = sortDescendingAriaLabel;
        return this;
    }

    public OfficeUiColumn onColumnClick(String onColumnClick) {
        this.onColumnClick = onColumnClick;
        return this;
    }

    public OfficeUiColumn isPadded(boolean isPadded) {
        this.isPadded = isPadded;
        return this;
    }
}