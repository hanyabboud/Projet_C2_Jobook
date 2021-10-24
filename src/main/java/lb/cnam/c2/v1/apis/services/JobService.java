package lb.cnam.c2.v1.apis.services;

import lb.cnam.c2.v1.apis.entities.JobEntity;
import lb.cnam.c2.v1.apis.modals.responses.Response;

public interface JobService {

	public Response fetchJobsByEnum(String body, String data, int jobEnum);

	public Response fetchJobsByUser(int userId);

	public Response createJob(JobEntity job);

	public Response deleteJob(int jobId);

}
