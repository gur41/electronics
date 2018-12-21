package project.model.note;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "processor_for_notebook", schema = "log", catalog = "")
public class ProcessorForNotebook {
    private Integer id;
    private String platform;
    private String processorName;
    private String modelProcessor;
    private Integer core;
    private Integer frequency;
    private Integer turboFrequency;
    private Integer powerUsage;
    private Collection<Notebook> notebooksById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "platform", nullable = true, length = 255)
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "processor_name", nullable = true, length = 255)
    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    @Basic
    @Column(name = "model_processor", nullable = true, length = 255)
    public String getModelProcessor() {
        return modelProcessor;
    }

    public void setModelProcessor(String modelProcessor) {
        this.modelProcessor = modelProcessor;
    }

    @Basic
    @Column(name = "core", nullable = true)
    public Integer getCore() {
        return core;
    }

    public void setCore(Integer core) {
        this.core = core;
    }

    @Basic
    @Column(name = "frequency", nullable = true)
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Basic
    @Column(name = "turbo_frequency", nullable = true)
    public Integer getTurboFrequency() {
        return turboFrequency;
    }

    public void setTurboFrequency(Integer turboFrequency) {
        this.turboFrequency = turboFrequency;
    }

    @Basic
    @Column(name = "power_usage", nullable = true)
    public Integer getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(Integer powerUsage) {
        this.powerUsage = powerUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcessorForNotebook that = (ProcessorForNotebook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
        if (processorName != null ? !processorName.equals(that.processorName) : that.processorName != null)
            return false;
        if (modelProcessor != null ? !modelProcessor.equals(that.modelProcessor) : that.modelProcessor != null)
            return false;
        if (core != null ? !core.equals(that.core) : that.core != null) return false;
        if (frequency != null ? !frequency.equals(that.frequency) : that.frequency != null) return false;
        if (turboFrequency != null ? !turboFrequency.equals(that.turboFrequency) : that.turboFrequency != null)
            return false;
        if (powerUsage != null ? !powerUsage.equals(that.powerUsage) : that.powerUsage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (processorName != null ? processorName.hashCode() : 0);
        result = 31 * result + (modelProcessor != null ? modelProcessor.hashCode() : 0);
        result = 31 * result + (core != null ? core.hashCode() : 0);
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        result = 31 * result + (turboFrequency != null ? turboFrequency.hashCode() : 0);
        result = 31 * result + (powerUsage != null ? powerUsage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "processorForNotebookByIdProcessorForNotebook")
    public Collection<Notebook> getNotebooksById() {
        return notebooksById;
    }

    public void setNotebooksById(Collection<Notebook> notebooksById) {
        this.notebooksById = notebooksById;
    }
}
